package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;

/**
 * TODO: get user commands text from a resource file, not hardcoded
 */

public class UserCommands extends CommandsAndVars {

    public UserCommands(int width, int height, FrontendController myFrontendController) {
        super(width, height, "User Commands", myFrontendController);
        setClick();
    }

    @Override
    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("UserCommands")));
    }
}
