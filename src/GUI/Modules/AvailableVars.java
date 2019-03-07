package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO: need to get list of available variables from somewhere along the backend
 * TODO: get available variables text from a resource file, not hardcoded
 */

public class AvailableVars extends Module{
    private VBox container;
    private List<String> availableVars;
    private ListView<String> availableVarsDisplay;
    private ObservableList<String> availableVarsCollection;

    public AvailableVars(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Available Variables", myFrontendController);
        availableVars = new ArrayList<>();
        //availableVars.add("Available Variables");
        //availableVars.add("Bye");
        setContent();
        setClick();
    }

    @Override
    protected void setContent() {
        container = new VBox();
//        content.setContent(container);
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
        content.getChildren().add(container);
    }

    private void setClick() {
        availableVarsDisplay.setCellFactory(lv -> {
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
                    //Possibly get a text box to pop up where we write in parameters
                    //context.sendCommandString(cell.getItem());
                    //context.addToPrevCommands(cell.getItem());

                }
            });
            return cell;
        });
    }

    public void setAvailableVars(Set<String> myAvailableVars) {
        availableVars.clear();
        availableVarsCollection.clear();
        for (String s: myAvailableVars) {
            availableVarsCollection.add(s);
            availableVars.add(s);
        }
    }
}
