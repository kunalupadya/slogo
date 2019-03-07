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
 * TODO: get user commands text from a resource file, not hardcoded
 */

public class UserCommands extends CommandsAndVars {

    public UserCommands(int width, int height, FrontendController myFrontendController) {
        super(width, height, "User Commands", myFrontendController);
        setClick();
    }

    @Override
    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label("User Commands"));
    }
}
