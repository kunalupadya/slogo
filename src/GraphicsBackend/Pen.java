package GraphicsBackend;

import javafx.scene.paint.Color;

import java.util.Optional;

/**
 * stores the state of the pen of a turtle
 * @author kunalupadya
 */
public class Pen implements ImmutablePen{

    private Color penColor;
    private boolean penUp = false;
    private int penSize = 1;

    public Pen(){
        this(Color.BLACK);
    }

    public Pen(Color color){
        penColor = color;
    }

    /**
     * gets the pen color
     * @return
     */
    public Color getMyPenColor(){
        return this.penColor;
    }

    /**
     * gets if the pen is up
     * @return
     */
    public boolean getPenUp() {
        return penUp;
    }

    /**
     * gets the thickness of the pen
     * @return
     */
    public int getPenSize(){ return penSize;}

    /**
     * sets the pen color, must be set through the turtle
     * @param color
     */
    protected void setPenColor(Color color) {
        this.penColor = color;
    }

    /**
     * sets the pen up or down, must be set through the turtle
     * @param penUp
     */
    protected void setPenUp(boolean penUp) {
        this.penUp = penUp;
    }

    /**
     * sets the pen thickness, must be set through the turtle
     * @param pixelSize
     */
    protected void setPenSize(int pixelSize){
        this.penSize = pixelSize;
    }
}