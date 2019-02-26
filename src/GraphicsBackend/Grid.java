package GraphicsBackend;

import javafx.scene.Node;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {
    private ArrayList<Node> myObjects = new ArrayList<>();
    private ArrayList<Line> bounds = new ArrayList<>();
    private double height;
    private double width;

    public Grid(double gridHeight, double gridWidth){
        width = gridWidth;
        height = gridHeight;
        initializeBounds();
    }

    private void initializeBounds() {
        getBounds(0,height,width,height);
        getBounds(0,0,width,0);
        getBounds(0,0,0,height);
        getBounds(width,0,width,height;
    }

    private void getBounds(double startX, double startY, double endX, double endY){
        Line line = new Line(startX, startY, endX, endY);
        bounds.add(line);
    }

    public Point addMovement(double xPos, double yPos, double angle, double dist, Pen pen){
        double newXPos = xPos + dist*Math.cos(Math.toRadians(angle));
        double newYPos = yPos + dist*Math.sin(Math.toRadians(angle));

        Line movement = new Line(xPos, yPos, newXPos, newYPos);
        Point movementStart = new Point(xPos,yPos);
        Point movementEnd = new Point(newXPos, newYPos);

        boolean offScreenRight = newXPos>width;
        boolean offScreenLeft = newXPos<0;
        boolean offScreenTop = newYPos<0;
        boolean offScreenBottom = newYPos>width;

        while(offScreenBottom|offScreenLeft|offScreenRight|offScreenTop){
            Point intersection = calculateIntersectionWithBounds(movementStart, movementEnd);
            createLine(pen, xPos, yPos, intersection.getMyX(), intersection.getMyY());
            double distanceTravelled = Math.sqrt(Math.pow(xPos-intersection.getMyX(),2)+Math.pow(yPos-intersection.getMyY(),2));
            dist -= distanceTravelled;
            if (intersection.getMyX() == 0){
                //offscreenleft
                xPos = intersection.getMyX();
                yPos = intersection.getMyY();
            }
            if (intersection.getMyY() == 0){
                //offscreentop
                xPos = intersection.getMyX();
                yPos = intersection.getMyY();
            }
            if (intersection.getMyX() == width){
                //offscreenright
                xPos = 0;
                yPos = intersection.getMyY();
            }
            if (intersection.getMyY() == 0){
                //offscreenbottom
                xPos = intersection.getMyX();
                yPos = 0;
            }
            offScreenRight = newXPos>width;
            offScreenLeft = newXPos<0;
            offScreenTop = newYPos<0;
            offScreenBottom = newYPos>width;
        }

//        if ()
        createLine(pen, xPos, yPos, newXPos, newYPos);
        return new Point(newXPos, newYPos);
    }

    private void createLine(Pen pen, double xPos, double yPos, double newXPos, double newYPos) {
        Line movement = new Line(xPos, yPos, newXPos, newYPos);
        movement.setStroke(pen.getPenColor());
        movement.setStrokeWidth(pen.getPenWidth());
        myObjects.add(movement);
    }

    private Point calculateIntersectionWithBounds(Point movementStart, Point movementEnd) {
        Point intersection = null;
        for (Line bound: bounds){
            intersection = calculateIntersection(movementStart, movementEnd, bound);
        }
        return intersection;
    }

    private Point calculateIntersection(Point movementStart, Point movementEnd, Line bound){
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

        if (determinant == 0)
        {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return null;
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;
            boolean a = (x>=movementStart.getMyX())&(x<=movementEnd.getMyX());
            boolean b = (x<=movementStart.getMyX())&(x>=movementEnd.getMyX());
            boolean c = (y>=movementStart.getMyY())&(y<=movementEnd.getMyY());
            boolean d = (y<=movementStart.getMyY())&(y>=movementEnd.getMyY());
            if ((a|b)&(c|d)){
                return new Point(x, y);
            }
            else{
                return null;
            }
        }
    }

    public List getAllObjects(){
        List<Node> returnArray = new ArrayList<>();
        Collections.copy(returnArray, myObjects);
        return returnArray;
    }
}
