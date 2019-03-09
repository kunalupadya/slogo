package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class PropertiesLoad extends ButtonControl {
    FrontendController context;

    /**
     * TODO: finish JavaDoc
     *
     * @param context
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