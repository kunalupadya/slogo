package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class StopExecution extends ButtonControl {
    private FrontendController context;

    public StopExecution(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/stop.png")), context);
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            // TODO: INTEGRATE
        };
    }
}
