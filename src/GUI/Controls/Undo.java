package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to undo the last action
 */
public class Undo extends ButtonControl {
    private FrontendController context;

    /**
     * @param context where this button is located
     */
    public Undo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/undo.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.undo();
    }
}
