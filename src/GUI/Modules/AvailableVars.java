package GUI.Modules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: need to get list of available variables from somewhere along the backend
 */

public class AvailableVars extends Module{
    private VBox container;
    private List<String> availableVars;
    private ListView<String> availableVarsDisplay;
    private ObservableList<String> availableVarsCollection;

    public AvailableVars(int width, int height) {
        super(width, height);
        availableVars = new ArrayList<>();
        availableVars.add("Hi");
        availableVars.add("Bye");
        //updateAvailableVars();
        setContent();
    }

    @Override
    protected void setLayout() {
        content.setPrefViewportWidth(moduleWidth);
        content.setPrefViewportHeight(moduleHeight);
        content.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        content.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }

    @Override
    protected void setStyle(){
    }

    @Override
    protected void setContent() {
        container = new VBox();
        content.setContent(container);
        container.prefHeightProperty().bind(content.heightProperty());
        if (availableVars != null) {
            availableVarsCollection = FXCollections.<String>observableArrayList(availableVars);
            availableVarsDisplay = new ListView<>(availableVarsCollection);
            availableVarsDisplay.setOrientation(Orientation.VERTICAL);
            availableVarsDisplay.prefHeightProperty().bind(container.heightProperty());
            availableVarsDisplay.setPrefWidth(moduleWidth);
        }
//        availableVarsDisplay.setEditable(false);
        container.getChildren().add(availableVarsDisplay);
    }

    private void updateAvailableVars() {
        //availableVars = ___.getList
    }
}
