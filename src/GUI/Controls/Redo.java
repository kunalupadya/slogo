package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.image.Image;

public class Redo extends Control {
    private WindowLayout context;

    public Redo(WindowLayout context) {
        super(new Image(WindowLayout.class.getResourceAsStream("/images/redo.png")));
        this.context = context;
    }

    @Override
    protected void action() {

    }
}
