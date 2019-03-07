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

/**
 * TODO: need to get list of user commands from somewhere along the backend
 * TODO: get user commands text from a resource file, not hardcoded
 */

public class UserCommands extends Module {
    private VBox container;
    private List<String> userCommands;
    private ListView<String> userCommandsDisplay;
    private ObservableList<String> userCommandsCollection;

    public UserCommands(int width, int height, FrontendController myFrontendController) {
        super(width, height, "User Commands", myFrontendController);
        userCommands = new ArrayList<>();
        userCommands.add("Sum 10 10");
        //userCommands.add("Nothing much");
        setContent();
        setClick();
    }

    @Override
    protected void setContent() {
        container = new VBox();
//        content.setContent(container);
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
        content.getChildren().add(container);
    }

    private void setClick() {
        userCommandsDisplay.setCellFactory(lv -> {
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

    public void setUserCommands(List<String> myUserCommands) {
        userCommands = myUserCommands;
    }
}
