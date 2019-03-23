package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to set the pen as up or down
 */
public class SetPenState extends ButtonControl{
    FrontendController context;

    /**
     * @param context where this button is located
     */
    public SetPenState(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/upDown.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.setPenState();
    }
}
