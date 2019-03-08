package GUI.Controls;

import GUI.FrontendController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

public class OpenHelp extends MenuButtonControl{
    private FrontendController context;

    public OpenHelp(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/help.png")), "/buttonProperties/HelpButtonLinks");
        this.context = context;
    }

    @Override
    protected EventHandler<ActionEvent> action() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            context.showHelp("/reference/" + mItem.getText());
        };
    }
}
