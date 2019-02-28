package GraphicsBackend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;


public class Turtle {
    public static final String DEFAULT_IMAGE = "initialTurtle.png";

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
        xPos = 0;
        yPos = 0;
        myAngle = 0;
        myGrid = grid;
        speed = 1;
        isTurtleVisible = true;
        turtleImage = new javafx.scene.image.Image(this.getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
        turtleImageView = new ImageView();
        updateTurtleImageview();
    }

    private void updateTurtleImageview() {
        turtleImageView.setImage(turtleImage);
        turtleImageView.setX(xPos);
        turtleImageView.setY(yPos);
        turtleImageView.setFitHeight(50);
        turtleImageView.setFitWidth(50);
    }

    public void move(double dist){

//        Line movement = new Line(xPos, yPos, newXPos, newYPos);
//        movement.setStroke(myPen.getPenColor());
//        movement.setStrokeWidth(myPen.getPenWidth());
        Point currentPosition = myGrid.addMovement(xPos, yPos, myAngle, dist, myPen);
        xPos = currentPosition.getMyX();
        yPos = currentPosition.getMyY();
        updateTurtleImageview();
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

    public ImageView getTurtleImageView() {
        return turtleImageView;
    }

    public Pen getMyPen() {
        return myPen;
    }
}
