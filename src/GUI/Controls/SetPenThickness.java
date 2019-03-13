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
        super(new Image(FrontendController.class.getResourceAsStream("/images/penThickness.png")), context,"/buttonProperties/PenThickness");
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String command = myResourceBundle.getString(mItem.getText());
            myContext.setPenThickness(Integer.parseInt(command));
        };
    }

    @Override
    public void setResourceBundle(String resourceBundleName) {
        myResourceBundle = ResourceBundle.getBundle("/buttonProperties/" + resourceBundleName);
    }
}
