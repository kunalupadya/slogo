package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to load the properties file
 */
public class PropertiesLoad extends ButtonControl {
    FrontendController context;

    /**
     * @param context where this button is located
     */
    public PropertiesLoad(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/load.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.load();
    }
}