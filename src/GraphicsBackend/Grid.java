package GraphicsBackend;

import javafx.scene.Node;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Grid {
    private ArrayList<Node> myObjects = new ArrayList<>();
    private double height;
    private double width;

    public Grid(double gridHeight, double gridWidth){
        width = gridWidth;
        height = gridHeight;
    }

    public Point addMovement(double xPos, double yPos, double angle, double dist, Pen pen){
        double newXPos = xPos + dist*Math.cos(Math.toRadians(angle));
        if (newXPos>width||newXPos<0){
            newXPos = width;
            //TODO finish this logic for if the turtle should wrap around
        }
        double newYPos = yPos + dist*Math.sin(Math.toRadians(angle));
        Line movement = new Line(xPos, yPos, newXPos, newYPos);
        if (newXPos>)
        movement.setStroke(pen.getPenColor());
        movement.setStrokeWidth(pen.getPenWidth());
        myObjects.add(movement);
        return new Point(newXPos, newYPos);
    }

    public List getAllObjects(){
        List<Node> returnArray = new ArrayList<>();
        Collections.copy(returnArray, myObjects);
        return returnArray;
    }
}
