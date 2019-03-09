package GraphicsBackend;

import javafx.scene.paint.Color;

import java.util.Optional;

/**
 * @author kunalupadya
 */
public class Pen implements ImmutablePen{

    //TODO Need to change pencolor to int
    private Color penColor;
    private boolean penUp = false;
    private int penSize = 1;

    public Pen(){
        this(Color.BLACK);
    }

    public Pen(Color color){
        penColor = color;
    }

    public Color getMyPenColor(){
        return this.penColor;
    }

    public boolean getPenUp() {
        return penUp;
    }

    public int getPenSize(){ return penSize;}

    protected void setPenColor(Color color) {
        this.penColor = color;
    }

    protected void setPenUp(boolean penUp) {
        this.penUp = penUp;
    }

    protected void setPenSize(int pixelSize){
        this.penSize = pixelSize;
    }
}