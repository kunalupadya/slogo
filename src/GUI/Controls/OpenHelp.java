package GUI.Controls;

import GUI.FrontendController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import java.util.ResourceBundle;

public class OpenHelp extends MenuButtonControl{
    public OpenHelp(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/help.png")), "/buttonProperties/HelpButtonLinks");
        this.myContext = context;
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            myContext.showHelp("/reference/" + mItem.getText());
        };
    }

    @Override
    public void setResourceBundle(String resourceBundleName) {
        myResourceBundle = ResourceBundle.getBundle("/buttonProperties/" + resourceBundleName);
    }
}
