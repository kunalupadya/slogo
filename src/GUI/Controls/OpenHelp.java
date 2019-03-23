package GUI.Controls;

import GUI.FrontendController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import java.util.ResourceBundle;

/**
 * Opens the help pop-up to get help for using functions.
 */
public class OpenHelp extends MenuButtonControl{
    /**
     * @param context where this button is located
     */
    public OpenHelp(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/help.png")), context, "/buttonProperties/HelpButtonLinks");
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            myContext.showHelp("/reference/" + mItem.getText());
        };
    }

    /**
     * Sets resourceBundle for this menuButton in case the resource bundle needs to be changed.
     *
     * @param resourceBundleName name of resourceBundle
     */
    @Override
    public void setResourceBundle(String resourceBundleName) {
        myResourceBundle = ResourceBundle.getBundle("/buttonProperties/" + resourceBundleName);
    }
}
