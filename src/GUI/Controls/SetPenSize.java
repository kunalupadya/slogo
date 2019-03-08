package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.image.Image;

import GUI.FrontendController;
import javafx.scene.input.MouseEvent;


public class SetPenSize extends ButtonControl {
    private FrontendController context;

    /**
     * TODO: finish JavaDoc
     *
     * @param image
     */
    public SetPenSize(Image image) {
        super(image);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            // TODO: INTEGRATE
        };
    }
}
