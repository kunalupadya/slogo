package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to set the turtle image
 */
public class SetTurtleImage extends ButtonControl {
    private FrontendController context;

    /**
     * @param context where this button is located
     */
    public SetTurtleImage(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/initialTurtle.png")), context);
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.handleSetTurtleImage();
    }
}
