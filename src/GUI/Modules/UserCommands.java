package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.ResourceBundle;

/**
 * TODO: get user commands text from a resource file, not hardcoded
 */

public class UserCommands extends CommandsAndVars {
    private ResourceBundle myResourceBundles;
    private ListView<String> listDisplay;

    public UserCommands(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        setClick();
    }

    @Override
    public void setPlaceholder() {
        myResourceBundles = getMyResourceBundles();
        listDisplay = getListDisplay();
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("UserCommands")));
    }
}
