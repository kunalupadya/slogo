package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SetTurtleImage extends ButtonControl {
    private FrontendController context;

    public SetTurtleImage(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/initialTurtle.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.handleSetTurtleImage();
    }
}
