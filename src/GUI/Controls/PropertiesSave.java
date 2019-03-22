package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to save properties as a txt file.
 */
public class PropertiesSave extends ButtonControl {
    FrontendController context;

    /**
     * @param context where this button is located
     */
    public PropertiesSave(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/save.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.save();
    }
}
