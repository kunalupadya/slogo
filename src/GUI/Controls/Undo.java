package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.image.Image;

public class Undo extends Control {
    private WindowLayout context;

    public Undo(WindowLayout context) {
        super(new Image(WindowLayout.class.getResourceAsStream("/images/undo.png")));
        this.context = context;
    }

    @Override
    protected void action() {

    }
}
