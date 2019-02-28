package GUI.Modules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

public class UserCommands extends Module {
    private VBox container;
    private List<String> userCommands;
    private ListView<String> userCommandsDisplay;
    private ObservableList<String> userCommandsCollection;

    public UserCommands(int width, int height) {
        super(width, height);
        userCommands.add("What's up");
        userCommands.add("Nothing much");
        setContent();
        //updateUserCommands();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        content.setContent(container);
        if (userCommands != null) {
            userCommandsCollection = FXCollections.<String>observableArrayList(userCommands);
            userCommandsDisplay = new ListView<>(userCommandsCollection);
            userCommandsDisplay.setOrientation(Orientation.VERTICAL);
            userCommandsDisplay.setPrefSize(moduleWidth, moduleHeight);
        }
        container.getChildren().add(userCommandsDisplay);
    }

    private void updateUserCommands() {
        //UserCommandList = ___.getList
    }

}
