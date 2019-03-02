package GraphicsBackend;

import javafx.scene.paint.Color;

public class Pen {

    //TODO Need to change pencolor to int
    Color penColor;
    boolean penUp = false;
    double penWidth = 1;
    int penSize = 10;

    public Pen(){
        this(Color.BLACK);
    }

    public Pen(Color color){
        penColor = color;
    }

    public Color getPenColor() {
        if (penUp) {
            return penColor;
        }
        return null;
    }

    public double getPenWidth() {
        return penWidth;
    }

    public boolean getPenUp() {
        return penUp;
    }

    public int getPenSize(){ return penSize;}


    //TODO: parameter as an integer -> accept integer and change that to color.s
    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public void setPenUp(boolean penUp) {
        this.penUp = penUp;
    }

    //TODO: I made this but need to implement a way that pensize will affect the line width - Louis
    public void setPenSize(int pixelSize){ this.penSize = pixelSize;}
}