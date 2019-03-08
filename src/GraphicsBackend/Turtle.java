package GraphicsBackend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.LinkedList;
import java.util.List;


public class Turtle implements ImmutableTurtle{
    public static final String DEFAULT_IMAGE = "/images/initialTurtle.png";
    public static final int TURTLE_SIZE = 50;
    public static final int HALF_TURTLE_SIZE = 25;
    public static final double HALF = 2.0;

    private double xPos;
    private double yPos;
    private double myAngle;
    private Pen myPen;
    private Image turtleImage;
    private Grid myGrid;
    private boolean isTurtleVisible;
    private boolean isTurtleActive;
    //TODO implement turtle shape using int index
    private int myShape;
    private LinkedList<ImmutableTurtleState> previousPositions = new LinkedList<>();
    private LinkedList<List<Line>> lastLinesPlaced = new LinkedList<>();


    public Turtle(Grid grid){
        myGrid = grid;
        xPos = myGrid.getWidth()/ HALF;
        yPos = myGrid.getHeight()/ HALF;
        myPen = new Pen();
        myAngle = 90;
        isTurtleVisible = true;
        isTurtleActive = true;
        turtleImage = new javafx.scene.image.Image(this.getClass().getResourceAsStream(DEFAULT_IMAGE));
    }

    private void updateATurtleImageView(ImageView turtle){
        turtle.setImage(turtleImage);
        turtle.setX(xPos-HALF_TURTLE_SIZE);
        turtle.setY(yPos-HALF_TURTLE_SIZE);
        turtle.setFitHeight(TURTLE_SIZE);
        turtle.setFitWidth(TURTLE_SIZE);
        turtle.setRotate(myAngle-90);
    }

    public boolean getIsTurtleActive(){
        return isTurtleActive;
    }

    public void setTurtleActive(boolean turtleActive) {
        isTurtleActive = turtleActive;
    }

    public void move(double dist){
        previousPositions.add(new TurtleState(new Point(xPos,yPos), myAngle));
        VectorMovement newPositionAndLines = myGrid.addMovement(xPos, yPos, myAngle, dist, myPen);
        Point newPosition = newPositionAndLines.getPosition();
        updateUndoBuffers(newPositionAndLines.getLinesAssociatedWithMovement());
        xPos = newPosition.getMyX();
        yPos = newPosition.getMyY();
    }

    public void moveTo(Point point){
        updateUndoBuffers(new LinkedList<>());
        xPos = point.getMyX()+myGrid.getWidth()/ HALF;
        yPos = myGrid.getHeight()/ HALF-point.getMyY();;
    }

    public void undo(){
        ImmutableTurtleState turtleState = previousPositions.removeLast();
        Point oldPos = turtleState.getPos();
        myGrid.removeLines(lastLinesPlaced.removeLast());
        xPos = oldPos.getMyX();
        yPos = oldPos.getMyY();
        myAngle = turtleState.getAngle();
    }

    public void turn(double angle){
        updateUndoBuffers(new LinkedList<>());
        myAngle += angle;
    }

    private void updateUndoBuffers(List<Line> lines) {
        previousPositions.add(new TurtleState(new Point(xPos,yPos), myAngle));
        lastLinesPlaced.add(lines);
    }

    public void turnTo(double angle){
        updateUndoBuffers(new LinkedList<>());
        myAngle = angle+90;
    }

    public void setTurtleVisibility(boolean visibility){
        isTurtleVisible = visibility;
    }

    public boolean isTurtleVisible(){
        return isTurtleVisible;
    }

    public double getyPos() {
        return yPos - myGrid.getHeight()/ HALF;
    }

    public double getxPos() {
        return xPos - myGrid.getWidth()/ HALF;
    }

    public Point getPos(){
        return new Point(getxPos(),getyPos());
    }

    public Grid getGrid() {
        return myGrid;
    }

    public int getMyShape(){ return myShape;}

    public double getMyAngle() {
        return myAngle-90;
    }

    public void setMyShape(int shapeIndex){this.myShape = shapeIndex;}

    public void setTurtleImage(Image turtleImage) {
        this.turtleImage = turtleImage;
    }

    public void setPenColor(Color color){
        myPen.setPenColor(color);
    }

    public void setPenSize(int pixelSize){
        myPen.setPenSize(pixelSize);
    }

    public void setPenUp(boolean penUp){
        myPen.setPenUp(penUp);
    }

    public ImageView getAdjustedTurtleImageView(double xLeftCorner, double yLeftCorner) {
        ImageView returnedTurtle = new ImageView();
        updateATurtleImageView(returnedTurtle);
        returnedTurtle.setX(returnedTurtle.getX()+xLeftCorner);
        returnedTurtle.setY(returnedTurtle.getY()+yLeftCorner);
        return returnedTurtle;
    }

    public ImmutablePen getMyPen() {
        return myPen;
    }
}
