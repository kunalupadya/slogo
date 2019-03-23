package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Button to load the properties file
 */
public class PropertiesLoad extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public PropertiesLoad(FrontendController context) {
        super("PropertiesLoad", context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.load();
    }
}