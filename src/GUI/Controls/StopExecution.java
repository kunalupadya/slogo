package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Button to stop the execution of code
 */
public class StopExecution extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public StopExecution(FrontendController context) {
        super("StopExecution", context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            // TODO: INTEGRATE
        };
    }
}
