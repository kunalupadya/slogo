package GraphicsBackend;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Grid {
    public static final double GRID_OFFSET = 0.001;
    public static final double MARGIN_OF_ERROR = 0.001;
    public static final double WRAPPING_WINDOW = 0.01;
    private ArrayList<Line> myObjects = new ArrayList<>();
    private ArrayList<Line> bounds = new ArrayList<>();
    private double height;
    private double width;
    //TODO make method so that screen color can be changed by the command
    private int ScreenColor;

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

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void clear(){
        myObjects.clear();
    }

    public Point addMovement(double xPos, double yPos, double angle, double dist, Pen pen){
        double newXPos = xPos - dist*Math.cos(Math.toRadians(angle));
        double newYPos = yPos - dist*Math.sin(Math.toRadians(angle));

        boolean offScreenRight = newXPos>width;
        boolean offScreenLeft = newXPos<0;
        boolean offScreenTop = newYPos<0;
        boolean offScreenBottom = newYPos>width;
        boolean offScreen = offScreenBottom|offScreenLeft|offScreenRight|offScreenTop;

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
            offScreenRight = newXPos>width;
            offScreenLeft = newXPos<0;
            offScreenTop = newYPos<0;
            offScreenBottom = newYPos>width;
            offScreen = offScreenBottom|offScreenLeft|offScreenRight|offScreenTop;
        }
        createLine(pen, xPos, yPos, newXPos, newYPos);
        return new Point(newXPos, newYPos);
    }

    private void createLine(Pen pen, double xPos, double yPos, double newXPos, double newYPos) {
        Line movement = new Line(xPos, yPos, newXPos, newYPos);
        if (pen.getPenColor().isPresent()) {
            movement.setStroke(pen.getPenColor().get());
            movement.setStrokeWidth(pen.getPenWidth());
            myObjects.add(movement);
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
        System.out.println("NULL");
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

            boolean xBetweenStartAndEndOfMovement = (x>=movementStart.getMyX()-MARGIN_OF_ERROR)&(x<=movementEnd.getMyX()+MARGIN_OF_ERROR);
            boolean xBetweenEndAndStartOfMovement = (x<=movementStart.getMyX()+MARGIN_OF_ERROR)&(x>=movementEnd.getMyX()-MARGIN_OF_ERROR);
            boolean yBetweenStartAndEndOfMovement = (y>=movementStart.getMyY()-MARGIN_OF_ERROR)&(y<=movementEnd.getMyY()+MARGIN_OF_ERROR);
            boolean yBetweenEndAndStartOfMovement = (y<=movementStart.getMyY()+MARGIN_OF_ERROR)&(y>=movementEnd.getMyY()-MARGIN_OF_ERROR);
            boolean pointOnInitialLine = xBetweenStartAndEndOfMovement|xBetweenEndAndStartOfMovement&yBetweenEndAndStartOfMovement|yBetweenStartAndEndOfMovement;

            boolean withinGridX = (x<=width+WRAPPING_WINDOW & x>=0-WRAPPING_WINDOW);
            boolean withinGridY = (y<=height+WRAPPING_WINDOW & y>=0-WRAPPING_WINDOW);
            boolean withinGrid = withinGridX & withinGridY;

            if (pointOnInitialLine&withinGrid){
                returnedPoint = Optional.of(new Point(x, y));
                return returnedPoint;
            }
            else{
                return returnedPoint;
            }
        }
    }

    public List<Line> getAllObjects(){
        return myObjects;
    }
}