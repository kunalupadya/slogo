package GraphicsBackend;

import javafx.scene.control.Alert;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author kunalupadya
 */
public class Grid implements ImmutableGrid{
    public static final double GRID_OFFSET = 0.01;
    public static final double MARGIN_OF_ERROR = 0.001;
    public static final double WRAPPING_WINDOW = 0.001;
    private ArrayList<Line> myObjects = new ArrayList<>();
    private ArrayList<Line> bounds = new ArrayList<>();
    private double height;
    private double width;
    //TODO make method so that screen color can be changed by the command
    private int ScreenColor;
//    private LinkedList<List<Line>> lastLinesPlaced = new LinkedList<>();
    private List<Line> newLineMovements;

    /**
     * constructor for the grid
     * @param gridHeight
     * @param gridWidth
     */
    public Grid(double gridHeight, double gridWidth){
        width = gridWidth;
        height = gridHeight;
        initializeBounds();
    }

    private void initializeBounds() {
        getBounds(0,height,width,height);
        getBounds(0,0,width,0);
        getBounds(0,0,0,height);
        getBounds(width,0,width,height);
    }

    private void getBounds(double startX, double startY, double endX, double endY){
        Line line = new Line(startX, startY, endX, endY);
        bounds.add(line);
    }

    protected double getHeight() {
        return height;
    }

    protected double getWidth() {
        return width;
    }

    /**
     * clears the grid
     */
    public void clear(){
        myObjects.clear();
    }

    protected void removeLines(List<Line> linesToRemove){
        for (Line l:linesToRemove){
            myObjects.remove(l);
        }
    }

    protected VectorMovement addMovement(double xPos, double yPos, double angle, double dist, Pen pen){
        newLineMovements = new LinkedList<>();
        double newXPos = xPos - dist*Math.cos(Math.toRadians(angle));
        double newYPos = yPos - dist*Math.sin(Math.toRadians(angle));

        boolean offScreen = isOffScreen(newXPos,newYPos);

        while(offScreen&dist>0){
            Point movementStart = new Point(xPos,yPos);
            Point movementEnd = new Point(newXPos, newYPos);
            Optional<Point> optionalIntersection = calculateIntersectionWithBounds(movementStart, movementEnd);
            Point intersection;
            if (optionalIntersection.isPresent()) {
                intersection = optionalIntersection.get();
            }
            else {
                new Alert(Alert.AlertType.ERROR, "Internal miscalculation - turtle is offscreen").showAndWait();
                //TODO deal with catching error
                break;
            }

            createLine(pen, xPos, yPos, intersection.getMyX(), intersection.getMyY());
            double distanceTravelled = Math.sqrt(Math.pow(xPos-intersection.getMyX(),2)+Math.pow(yPos-intersection.getMyY(),2));
            dist -= distanceTravelled;

            if (intersection.getMyX() == 0){
                //offscreenleft
                xPos = width-GRID_OFFSET;
                yPos = intersection.getMyY();
            }
            else if (intersection.getMyY() == 0){
                //offscreentop
                xPos = intersection.getMyX();
                yPos = height-GRID_OFFSET;
            }
            else if (intersection.getMyX() == width){
                //offscreenright
                xPos = 0+GRID_OFFSET;
                yPos = intersection.getMyY();
            }
            else if (intersection.getMyY() == height){
                //offscreenbottom
                xPos = intersection.getMyX();
                yPos = 0+GRID_OFFSET;
            }

            newXPos = xPos - dist*Math.cos(Math.toRadians(angle));
            newYPos = yPos - dist*Math.sin(Math.toRadians(angle));
            offScreen = isOffScreen(newXPos, newYPos);
        }
        createLine(pen, xPos, yPos, newXPos, newYPos);
        return new VectorMovement(new Point(newXPos, newYPos), newLineMovements);
    }

    private boolean isOffScreen(double newXPos, double newYPos) {
        boolean offScreenRight = newXPos>width;
        boolean offScreenLeft = newXPos<0;
        boolean offScreenTop = newYPos<0;
        boolean offScreenBottom = newYPos>width;
        boolean offScreen = offScreenBottom|offScreenLeft|offScreenRight|offScreenTop;
        return offScreen;
    }

    private void createLine(Pen pen, double xPos, double yPos, double newXPos, double newYPos) {
        Line movement = new Line(xPos, yPos, newXPos, newYPos);
        if (!pen.getPenUp()) {
            movement.setStroke(pen.getMyPenColor());
            movement.setStrokeWidth(pen.getPenSize());
            myObjects.add(movement);
            newLineMovements.add(movement);
        }
    }

    private Optional<Point> calculateIntersectionWithBounds(Point movementStart, Point movementEnd) {
        Optional<Point> intersectOptional = Optional.empty();
        for (Line bound: bounds){
            intersectOptional = calculateIntersection(movementStart, movementEnd, bound);
            if (intersectOptional.isPresent()){
                return intersectOptional;
            }
        }
        return intersectOptional;
    }

    private Optional<Point> calculateIntersection(Point movementStart, Point movementEnd, Line bound){
        // Line AB represented as a1x + b1y = c1
        Point C = new Point(bound.getStartX(), bound.getStartY());
        Point D = new Point(bound.getEndX(), bound.getEndY());
        double a1 = movementEnd.getMyY() - movementStart.getMyY();
        double b1 = movementStart.getMyX() - movementEnd.getMyX();
        double c1 = a1*(movementStart.getMyX()) + b1*(movementStart.getMyY());

        // Line CD represented as a2x + b2y = c2
        double a2 = D.getMyY() - C.getMyY();
        double b2 = C.getMyX() - D.getMyX();
        double c2 = a2*(C.getMyX())+ b2*(C.getMyY());

        double determinant = a1*b2 - a2*b1;
        Optional<Point> returnedPoint = Optional.empty();
        if (determinant == 0)
        {
            // The lines are parallel, return empty optional
            return returnedPoint;
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;

            boolean xBetweenStartAndEndOfMovement = (x>=movementStart.getMyX()-MARGIN_OF_ERROR)&&(x<=movementEnd.getMyX()+MARGIN_OF_ERROR);
            boolean xBetweenEndAndStartOfMovement = (x<=movementStart.getMyX()+MARGIN_OF_ERROR)&&(x>=movementEnd.getMyX()-MARGIN_OF_ERROR);
            boolean yBetweenStartAndEndOfMovement = (y>=movementStart.getMyY()-MARGIN_OF_ERROR)&&(y<=movementEnd.getMyY()+MARGIN_OF_ERROR);
            boolean yBetweenEndAndStartOfMovement = (y<=movementStart.getMyY()+MARGIN_OF_ERROR)&&(y>=movementEnd.getMyY()-MARGIN_OF_ERROR);
            boolean pointOnInitialLine = (xBetweenStartAndEndOfMovement|xBetweenEndAndStartOfMovement)&(yBetweenEndAndStartOfMovement|yBetweenStartAndEndOfMovement);

            boolean withinGridX = (x<=width+WRAPPING_WINDOW && x>=0-WRAPPING_WINDOW);
            boolean withinGridY = (y<=height+WRAPPING_WINDOW && y>=0-WRAPPING_WINDOW);
            boolean withinGrid = withinGridX & withinGridY;

            if (pointOnInitialLine&withinGrid){
                returnedPoint = Optional.of(new Point(x, y));
            }
            return returnedPoint;
        }
    }

    /**
     * gets all lines
     * @return
     */
    public List<Line> getAllObjects(){
        return myObjects;
    }
}