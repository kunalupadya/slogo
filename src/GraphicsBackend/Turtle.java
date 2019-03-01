package GraphicsBackend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Turtle {
    public static final String DEFAULT_IMAGE = "initialTurtle.png";
    public static final int TURTLE_SIZE = 50;
    public static final int HALF_TURTLE_SIZE = 25;
    public static final double HALF = 2.0;

    private double xPos;
    private double yPos;
    private double myAngle;
    private double speed;
    private Pen myPen = new Pen();
    private Image turtleImage;
    private ImageView turtleImageView;
    private Grid myGrid;
    private boolean isTurtleVisible;

    public Turtle(Grid grid){
        myGrid = grid;
        xPos = myGrid.getWidth()/ HALF;
        yPos = myGrid.getHeight()/ HALF;
        myAngle = 0;
        speed = 1;
        isTurtleVisible = true;
        turtleImage = new javafx.scene.image.Image(this.getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
//        turtleImageView = new ImageView();
//        updateThisTurtleImageview();
    }

//    private void updateThisTurtleImageview() {
//        updateATurtleImageView(turtleImageView);
//    }

    public void updateATurtleImageView(ImageView turtle){
        turtle.setImage(turtleImage);
        turtle.setX(xPos-HALF_TURTLE_SIZE);
        turtle.setY(yPos-HALF_TURTLE_SIZE);
        turtle.setFitHeight(TURTLE_SIZE);
        turtle.setFitWidth(TURTLE_SIZE);
    }

    public void move(double dist){

//        Line movement = new Line(xPos, yPos, newXPos, newYPos);
//        movement.setStroke(myPen.getPenColor());
//        movement.setStrokeWidth(myPen.getPenWidth());
        Point currentPosition = myGrid.addMovement(xPos, yPos, myAngle, dist, myPen);
        xPos = currentPosition.getMyX();
        yPos = currentPosition.getMyY();
//        updateThisTurtleImageview();
//        xPos = newXPos;
//        yPos = newYPos;
    }

    public void moveTo(Point point){
        xPos = point.getMyX();
        yPos = point.getMyY();
    }

    public void turn(double angle){
        myAngle += angle;
    }

    public void setTurtleVisibility(boolean visibility){
        isTurtleVisible = visibility;
    }

    public boolean isTurtleVisible(){
        return isTurtleVisible;
    }

    public double getyPos() {
        return yPos;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getMyAngle() {
        return myAngle;
    }

    public void setTurtleImage(Image turtleImage) {
        this.turtleImage = turtleImage;
    }

    public ImageView getAdjustedTurtleImageView(double xLeftCorner, double yLeftCorner) {
        ImageView returnedTurtle = new ImageView();
        updateATurtleImageView(returnedTurtle);
        returnedTurtle.setX(returnedTurtle.getX()+xLeftCorner);
        returnedTurtle.setX(returnedTurtle.getX()+yLeftCorner);
        return returnedTurtle;
    }

    public Pen getMyPen() {
        return myPen;
    }
}
