package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.ResourceBundle;

/**
 * @author David Liu
 */

/**
 * UserCommands Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize UserCommands with width 200 and height 250, with a moduleName of "UserCommands" and a new FrontendController
 * object
 */
public class UserCommands extends CommandsAndVars {
    private ResourceBundle myResourceBundles;
    private ListView<String> listDisplay;

    /**
     * Constructor of UserCommands, sets up the two Panes that contains all the necessary content and labels
     * Also sets up the list associated with the view that will be displayed
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public UserCommands(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        setClick();
    }

    @Override
    protected void setPlaceholder() {
        myResourceBundles = getMyResourceBundles();
        listDisplay = getListDisplay();
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("UserCommands")));
    }
}
