package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Button to undo the last action
 */
public class Undo extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public Undo(FrontendController context) {
        super("Undo", context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.undo();
    }
}
