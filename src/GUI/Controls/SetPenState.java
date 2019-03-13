package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SetPenState extends ButtonControl{
    public SetPenState(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/upDown.png")), context);
    }
    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.setPenState();
    }
}
