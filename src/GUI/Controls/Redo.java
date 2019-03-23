package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to redo last undone action
 */
public class Redo extends ButtonControl {

    /**
     * @param context where this button is located
     */
    public Redo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/redo.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            // TODO: INTEGRATE
        };
    }
}
