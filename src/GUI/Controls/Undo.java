package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to undo the last action
 */
public class Undo extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public Undo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/undo.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.undo();
    }
}
