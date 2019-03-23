package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;

import GUI.FrontendController;

/**
 * Button to switch the current language settings
 */
public class SwitchLanguages extends MenuButtonControl{
    /**
     * @param context where this button is located
     */
    public SwitchLanguages(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/language.png")), context,"/languageProperties/LanguageSettings");
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            myContext.changeLanguage(mItem.getText());
        };
    }

    /**
     * Sets resourceBundle for this menuButton in case the resource bundle needs to be changed.
     *
     * @param resourceBundleName name of resourceBundle
     */
    @Override
    public void setResourceBundle(String resourceBundleName) {
        myResourceBundle = ResourceBundle.getBundle("/languageProperties/" + resourceBundleName);
    }
}
