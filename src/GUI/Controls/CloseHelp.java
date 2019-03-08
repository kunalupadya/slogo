package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CloseHelp extends ButtonControl {
    FrontendController context;

    public CloseHelp(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/close.png")));
        this.context = context;

        this.myButton.getStyleClass().add("close-button");
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.closeHelp();
    }
}
