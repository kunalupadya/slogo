package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import GUI.FrontendController;

public class MoveTurtle extends MenuButtonControl{
    private FrontendController context;

    /**
     * TODO: Refactor so that all the buttons can extend control
     * TODO: Refactor this class so that all MenuItem objects are initialized in another method
     * TODO: Add setOnAction() for each MenuItem
     * @param context
     */
    public MoveTurtle(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/moveTurtle.png")), "/buttonProperties/TurtleMovements");
        this.context = context;
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String command = myResourceBundle.getString(mItem.getText());
            context.sendCommandString(command);
        };
    }
}
