package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Button to set the pen as up or down
 */
public class SetPenState extends ButtonControl{
    /**
     * @param context where this button is located
     */
    public SetPenState(FrontendController context) {
        super("SetPenState", context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.setPenState();
    }
}
