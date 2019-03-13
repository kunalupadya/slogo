package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CloseHelp extends ButtonControl {
    Group myHelpGroup;

    public CloseHelp(FrontendController context, Group helpGroup) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/close.png")), context);
        this.myHelpGroup = helpGroup;
        this.myButton.getStyleClass().add("close-button");
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.closeHelp(myHelpGroup);
    }
}
