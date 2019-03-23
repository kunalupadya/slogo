package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;

import GUI.FrontendController;

/**
 * Opens up a drop-down menu to move the turtle graphically.
 */
public class MoveTurtle extends MenuButtonControl{
    private ResourceBundle languageResourceBundle;

    /**
     * @param context where this button is located
     */
    public MoveTurtle(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/moveTurtle.png")), context,"/buttonProperties/TurtleMovements");
        languageResourceBundle = ResourceBundle.getBundle("/languageProperties/English");
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String command = languageResourceBundle.getString(mItem.getText());
            String[] commands = command.split("\\|");
            myContext.sendCommandString(commands[1] + " 10");
        };
    }

    /**
     * Sets resourceBundle for this menuButton in case the resource bundle needs to be changed.
     *
     * @param myLanguage name of resourceBundle
     */
    public void setResourceBundle(String myLanguage) {
        languageResourceBundle = ResourceBundle.getBundle("/languageProperties/" + myLanguage);
    }
}
