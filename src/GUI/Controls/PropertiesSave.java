package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to save properties as a txt file.
 */
public class PropertiesSave extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public PropertiesSave(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/save.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.save();
    }
}
