package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.image.Image;

public class SetTurtleImage extends Control {
    private WindowLayout context;

    public SetTurtleImage(WindowLayout context) {
        super(new Image(WindowLayout.class.getResourceAsStream("/images/initialTurtle.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.handleSetTurtleImage();
    }
}
