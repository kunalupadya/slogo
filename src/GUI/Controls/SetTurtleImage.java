package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
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
        super("SetTurtleImage", context);
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.handleSetTurtleImage();
    }
}
