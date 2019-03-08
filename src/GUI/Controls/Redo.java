package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Redo extends ButtonControl {
    private FrontendController context;

    public Redo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/redo.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            // TODO: INTEGRATE
        };
    }
}
