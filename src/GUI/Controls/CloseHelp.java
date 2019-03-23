package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to close pop-up menus. Needs an associated method in context.
 */
public class CloseHelp extends ButtonControl {
    Group myHelpGroup;

    /**
     * @param context where this button is located
     */
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
