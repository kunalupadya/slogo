package GUI.Modules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: need to get list of user commands from somewhere along the backend
 * TODO: get user commands text from a resource file, not hardcoded
 */

public class UserCommands extends Module {
    private VBox container;
    private List<String> userCommands;
    private ListView<String> userCommandsDisplay;
    private ObservableList<String> userCommandsCollection;

    public UserCommands(int width, int height) {
        super(width, height);
        userCommands = new ArrayList<>();
        //serCommands.add("What's up");
        //userCommands.add("Nothing much");
        setContent();
        //updateUserCommands();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        content.setContent(container);
        container.prefHeightProperty().bind(content.heightProperty());
        if (userCommands != null) {
            userCommandsCollection = FXCollections.<String>observableArrayList(userCommands);
            userCommandsDisplay = new ListView<>(userCommandsCollection);
            userCommandsDisplay.setOrientation(Orientation.VERTICAL);
            userCommandsDisplay.prefHeightProperty().bind(container.heightProperty());
            userCommandsDisplay.setPrefWidth(moduleWidth);
            userCommandsDisplay.setPlaceholder(new Label("User Commands"));
        }
        container.getChildren().add(userCommandsDisplay);
    }

    private void updateUserCommands() {
        //UserCommandList = ___.getList
    }

}
