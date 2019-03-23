package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.Set;

/**
 * @author David Liu
 */

/**
 * CommandsAndVars Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize UserCommands with width 200 and height 250, with a moduleName of "UserCommands" and a new FrontendController
 * object
 */
public class CommandsAndVars extends ListModule {
    private FrontendController context;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

    /**
     * Constructor of CommandsAndVars, sets up the two Panes that contains all the necessary content and labels
     * Also sets up the list associated with the view that will be displayed
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public CommandsAndVars(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        context = getContext();
        list = getList();
        listDisplay = getListDisplay();
        listCollection = getListCollection();
        setClick();
    }

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
                    context.addToConsole(cell.getItem());
                }
            });
            return cell;
        });
    }

    /**
     * Sets the list of strings in the view to what is available from the back-end currently (UserCommands or AvailableVars)
     * @param myList set of strings taken from the back-end to display in the view
     */
    public void setList(Set<String> myList) {
        list.clear();
        listCollection.clear();
        for (String s: myList) {
            listCollection.add(s);
            list.add(s);
        }
    }

    protected void setPlaceholder() {
    }
}
