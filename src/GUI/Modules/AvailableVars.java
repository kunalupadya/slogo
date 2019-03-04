package GUI.Modules;

import GUI.WindowLayout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: need to get list of available variables from somewhere along the backend
 * TODO: get available variables text from a resource file, not hardcoded
 */

public class AvailableVars extends Module{
    private VBox container;
    private List<String> availableVars;
    private ListView<String> availableVarsDisplay;
    private ObservableList<String> availableVarsCollection;

    public AvailableVars(int width, int height, WindowLayout myWindowLayout) {
        super(width, height, "Available Variables", myWindowLayout);
        availableVars = new ArrayList<>();
        //availableVars.add("Available Variables");
        //availableVars.add("Bye");
        setContent();
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
            availableVarsDisplay.setPlaceholder(new Label("Available Variables"));
        }
//        availableVarsDisplay.setEditable(false);
        container.getChildren().add(availableVarsDisplay);
    }

    public void setAvailableVars(List<String> myAvailableVars) {
        availableVars = myAvailableVars;
    }
}
