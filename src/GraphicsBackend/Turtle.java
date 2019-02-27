package GraphicsBackend;

import javafx.scene.shape.Line;

import java.awt.*;

public class Turtle {
    public static final String DEFAULT_IMAGE = "turtle.png";

    private double xPos;
    private double yPos;
    private double myAngle;
    private double speed;
    private Pen myPen = new Pen();
    private Image turtleImage;
    private Grid myGrid;

    public Turtle(Grid grid){
        xPos = 0;
        yPos = 0;
        myAngle = 0;
        myGrid = grid;
        speed = 1;
        var turtleImage = new javafx.scene.image.Image(this.getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
    }

    public void move(double dist){

//        Line movement = new Line(xPos, yPos, newXPos, newYPos);
//        movement.setStroke(myPen.getPenColor());
//        movement.setStrokeWidth(myPen.getPenWidth());
        myGrid.addMovement(xPos, yPos, myAngle, dist, myPen);
//        xPos = newXPos;
//        yPos = newYPos;
    }

    public void turn(double angle){
        myAngle += angle;
    }

    public double getyPos() {
        return yPos;
    }

    public double getxPos() {
        return xPos;
    }

    public double getMyAngle() {
        return myAngle;
    }

    public void setTurtleImage(Image turtleImage) {
        this.turtleImage = turtleImage;
    }

    public Pen getMyPen() {
        return myPen;
    }
}
