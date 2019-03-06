package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.image.Image;

public class SetTurtleImage extends Control {
    private FrontendController context;

    public SetTurtleImage(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/initialTurtle.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.handleSetTurtleImage();
    }
}
