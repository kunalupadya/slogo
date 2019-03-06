package GraphicsBackend;

import javafx.scene.paint.Color;

import java.util.Optional;

public class Pen {

    //TODO Need to change pencolor to int
    private Color penColor;
    private boolean penUp = false;
    private double penWidth = 1;
    private int penSize = 10;

    public Pen(){
        this(Color.BLACK);
    }

    public Pen(Color color){
        penColor = color;
    }

    public Optional<Color> getPenColor() {
        return penColor;
    }

    public Color getMyPenColor(){
        return this.penColor;
    }

    public double getPenWidth() {
        return penWidth;
    }

    public boolean getPenUp() {
        return penUp;
    }

    public int getPenSize(){ return penSize;}


    //TODO: parameter as an integer -> accept integer and change that to color.s
    public void setPenColor(Color color) {
        this.penColor = color;
    }

    public void setPenUp(boolean penUp) {
        this.penUp = penUp;
    }

    //TODO: I made this but need to implement a way that pensize will affect the line width - Louis
    public void setPenSize(int pixelSize){ this.penSize = pixelSize;}
}