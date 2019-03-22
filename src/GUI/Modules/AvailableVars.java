package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import java.util.ResourceBundle;

/**
 * @author David Liu
 */

/**
 * AvailableVars Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize AvailableVars with width 200 and height 250, with a moduleName of "AvailableVars" and a new FrontendController
 * object
 */
public class AvailableVars extends CommandsAndVars{
    private FrontendController context;
    private ResourceBundle myResourceBundles;
    private ListView<String> listDisplay;

    /**
     * Constructor of AvailableVars, sets up the two Panes that contains all the necessary content and labels
     * Also sets up the list associated with the view that will be displayed
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public AvailableVars(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        context = getContext();
        setClick();
    }

    @Override
    protected void setClick() {
        listDisplay.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    context.addToConsole(":" + cell.getItem());
                }
            });
            return cell;
        });
    }

    @Override
    protected void setPlaceholder() {
        myResourceBundles = getMyResourceBundles();
        listDisplay = getListDisplay();
        String availableVars = myResourceBundles.getString("AvailableVars");
        listDisplay.setPlaceholder(new Label(availableVars));
    }
}
