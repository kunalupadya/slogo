package GraphicsBackend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.LinkedList;
import java.util.List;


/**
 * the object holding each turtle's state (location, direction, image, active/visible, etc.)
 * @author kunalupadya
 */
public class Turtle implements FrontendImmutableTurtle {
    private static final String DEFAULT_IMAGE = "/images/initialTurtle.png";
    private static final int TURTLE_SIZE = 50;
    private static final int HALF_TURTLE_SIZE = 25;
    private static final double HALF = 2.0;
    public static final int STARTING_ANGLE = 90;

    private double xPos;
    private double yPos;
    private double myAngle;
    private Pen myPen;
    private Image turtleImage;
    private Grid myGrid;
    private boolean isTurtleVisible;
    private boolean isTurtleActive;
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

    private void updateTurtleImageView(ImageView turtle){
        turtle.setImage(turtleImage);
        turtle.setX(xPos-HALF_TURTLE_SIZE);
        turtle.setY(yPos-HALF_TURTLE_SIZE);
        turtle.setFitHeight(TURTLE_SIZE);
        turtle.setFitWidth(TURTLE_SIZE);
        turtle.setRotate(myAngle-STARTING_ANGLE);
    }

    /**
     * gets if a turtle is active
     * @return
     */
    public boolean getIsTurtleActive(){
        return isTurtleActive;
    }

    /**
     * sets a turtle to be active or inactive, used by the frontend controller and the tell command
     * @param turtleActive
     */
    public void setTurtleActive(boolean turtleActive) {
        isTurtleActive = turtleActive;
    }

    /**
     * moves the turtle forward, unavailable from frontend, used only by commands being executed
     * @param dist
     */
    public void move(double dist){
        previousPositions.add(new TurtleState(new Point(xPos,yPos), myAngle));
        VectorMovement newPositionAndLines = myGrid.addMovement(xPos, yPos, myAngle, dist, myPen);
        Point newPosition = newPositionAndLines.getPosition();
        updateUndoBuffers(newPositionAndLines.getLinesAssociatedWithMovement());
        xPos = newPosition.getMyX();
        yPos = newPosition.getMyY();
    }

    /**
     * move to a particular location
     * @param point
     */
    public void moveTo(Point point){
        updateUndoBuffers(new LinkedList<>());
        xPos = point.getMyX()+myGrid.getWidth()/ HALF;
        yPos = myGrid.getHeight()/ HALF-point.getMyY();
    }

    /**
     * undoes previous command
     */
    public void undo(){
        if (!previousPositions.isEmpty()) {
            ImmutableTurtleState turtleState = previousPositions.removeLast();
            Point oldPos = turtleState.getPos();
            if (!lastLinesPlaced.isEmpty()) {
                myGrid.removeLines(lastLinesPlaced.removeLast());
            }
            xPos = oldPos.getMyX();
            yPos = oldPos.getMyY();
            myAngle = turtleState.getAngle();
        }
    }

    /**
     * turns the turtle, unavailable from frontend, only used by commands being executed
     * @param angle
     */
    public void turn(double angle){
        updateUndoBuffers(new LinkedList<>());
        myAngle += angle;
    }

    /**
     * updates the buffers holding previous undo actions
     * @param lines
     */
    private void updateUndoBuffers(List<Line> lines) {
        previousPositions.add(new TurtleState(new Point(xPos,yPos), myAngle));
        lastLinesPlaced.add(lines);
    }

    /**
     * turns to a particular angle, unavailable from frontend, only used by commands being executed
     * @param angle
     */
    public void turnTo(double angle){
        updateUndoBuffers(new LinkedList<>());
        myAngle = angle+STARTING_ANGLE;
    }

    /**
     * sets the turtle visible or invisible
     * @param visibility
     */
    public void setTurtleVisibility(boolean visibility){
        isTurtleVisible = visibility;
    }

    /**
     * gets if the turtle is currently visible
     * @return
     */
    public boolean isTurtleVisible(){
        return isTurtleVisible;
    }

    /**
     * gets the xposition
     * example: if screenwidth is 400, returns a value in the range of -200 to 200, where 200 is the right of the screen
     * @return
     */
    public double getUserFriendlyXPos(){
        return xPos - myGrid.getWidth()/ HALF;
    }

    /**
     * gets the yposition
     * example: if screenheight is 400, returns a value in the range of -200 to 200, where 200 is the top of the screen
     * @return
     */
    public double getUserFriendlyYPos(){
        return myGrid.getHeight()/ HALF-yPos;
    }

    /**
     * gets a point object holding the current location
     * @return
     */
    public Point getPos(){
        return new Point(getUserFriendlyXPos(),getUserFriendlyYPos());
    }

    /**
     * gets the grid that the turtle is on
     * @return
     */
    public Grid getGrid() {
        return myGrid;
    }

    /**
     * gets the shape index
     * @return
     */
    public int getMyShape(){ return myShape;}

    /**
     * gets the angle the turtle is currently at, where 0 is north
     * @return
     */
    public double getMyAngle() {
        return myAngle- STARTING_ANGLE;
    }

    /**
     * sets the shape index
     * @param shapeIndex
     */
    public void setMyShape(int shapeIndex){this.myShape = shapeIndex;}

    /**
     * sets the turtle image
     * @param turtleImage
     */
    public void setTurtleImage(Image turtleImage) {
        this.turtleImage = turtleImage;
    }

    /**
     * sets the pen color
     * @param color
     */
    public void setPenColor(Color color){
        myPen.setPenColor(color);
    }

    /**
     * sets the pen thickness
     * @param pixelSize
     */
    public void setPenSize(int pixelSize){
        myPen.setPenSize(pixelSize);
    }

    /**
     * sets if the pen is up or down
     * @param penUp
     */
    public void setPenUp(boolean penUp){
        myPen.setPenUp(penUp);
    }

    /**
     * gets the imageview of the turtle
     * @param xLeftCorner
     * @param yLeftCorner
     * @return
     */
    public ImageView getAdjustedTurtleImageView(double xLeftCorner, double yLeftCorner) {
        ImageView returnedTurtle = new ImageView();
        updateTurtleImageView(returnedTurtle);
        returnedTurtle.setX(returnedTurtle.getX()+xLeftCorner);
        returnedTurtle.setY(returnedTurtle.getY()+yLeftCorner);
        return returnedTurtle;
    }

    /**
     * gets an turtle meant to be used by the frontend
     */
    public FrontendImmutableTurtle getFrontendImmutableTurtle(){
        return this;
    }

    /**
     * gets an immutable pen for use with the frontend
     * @return
     */
    public ImmutablePen getMyPen() {
        return myPen;
    }
}
