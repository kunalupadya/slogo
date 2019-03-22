package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to stop the execution of code
 */
public class StopExecution extends ButtonControl {
    private FrontendController context;

    /**
     * @param context where this button is located
     */
    public StopExecution(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/stop.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            // TODO: INTEGRATE
        };
    }
}
