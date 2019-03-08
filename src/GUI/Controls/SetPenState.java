package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SetPenState extends ButtonControl{
    FrontendController context;

    public SetPenState(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/upDown.png")));
        this.context = context;
    }
    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.setPenState();
    }
}
