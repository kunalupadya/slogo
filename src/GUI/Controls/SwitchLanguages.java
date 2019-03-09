package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;

import GUI.FrontendController;

public class SwitchLanguages extends MenuButtonControl{
    /**
     *
     * @param context
     */
    public SwitchLanguages(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/language.png")), "/languageProperties/LanguageSettings");
        this.myContext = context;
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            myContext.changeLanguage(mItem.getText());
        };
    }

    @Override
    public void setResourceBundle(String resourceBundleName) {
        myResourceBundle = ResourceBundle.getBundle("/languageProperties/" + resourceBundleName);
    }
}
