package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Undo extends ButtonControl {
    public Undo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/undo.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.undo();
    }
}
