package GraphicsBackend;

import javafx.scene.paint.Color;

public class Pen {

    Color penColor;
    boolean penUp = false;
    double penWidth = 1;

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

    public boolean getPenUp(boolean penUp) {
        return penUp;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public void setPenUp(boolean penUp) {
        this.penUp = penUp;
    }
}
