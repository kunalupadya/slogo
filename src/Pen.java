import javafx.scene.paint.Color;

public class Pen {

    Color penColor;
    boolean penUp;

    public Pen(){
        this(Color.BLACK);

    }

    public Pen(Color color){
        penColor = color;
    }
}
