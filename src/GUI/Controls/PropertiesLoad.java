package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class PropertiesLoad extends ButtonControl {
    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public PropertiesLoad(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/load.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.load();
    }
}