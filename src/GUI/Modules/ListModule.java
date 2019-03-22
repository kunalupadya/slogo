package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Liu
 */

/**
 * Abstract ListModule Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize a ListModule with width 200 and height 250, with a moduleName of "CurrentState" and a new FrontendController
 * object
 */
public abstract class ListModule extends Module {
    private VBox container;
    private Pane content;
    private int moduleWidth;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

    /**
     * Constructor of ListModule, sets up the two Panes that contains all the necessary content and labels
     * Also sets up the list associated with the view that will be displayed
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public ListModule(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        list = new ArrayList<>();
        content = getPane();
        moduleWidth = getModuleWidth();
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.prefHeightProperty().bind(content.heightProperty());
        if (list != null) {
            listCollection = FXCollections.observableArrayList(list);
            listDisplay = new ListView<>(listCollection);
            listDisplay.setOrientation(Orientation.VERTICAL);
            listDisplay.prefHeightProperty().bind(container.heightProperty());
            listDisplay.setPrefWidth(moduleWidth);
            setPlaceholder();
        }
        container.getChildren().add(listDisplay);
        content.getChildren().add(container);
    }

    protected abstract void setPlaceholder();

    /**
     * Gets list that will be displayed
     * @return List of strings
     */
    public List<String> getList() {
        return list;
    }

    /**
     * Gets listview that will help show the list which will be displayed
     * @return ListView of Strings
     */
    public ListView<String> getListDisplay() {
        return listDisplay;
    }

    /**
     * Gets observablelist that will help show the list which will be displayed
     * @return ObservableList of Strings
     */
    public ObservableList<String> getListCollection() {
        return listCollection;
    }
}
