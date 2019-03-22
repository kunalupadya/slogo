package GUI.Controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import GUI.FrontendController;

import java.util.ResourceBundle;

public class SetPenThickness extends MenuButtonControl {
    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public SetPenThickness(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/penThickness.png")), "/buttonProperties/PenThickness");
        this.myContext = context;
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String command = myResourceBundle.getString(mItem.getText());
            myContext.setPenThickness(Integer.parseInt(command));
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
