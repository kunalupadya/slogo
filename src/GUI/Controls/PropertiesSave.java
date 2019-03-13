package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class PropertiesSave extends ButtonControl {
    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public PropertiesSave(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/save.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.save();
    }
}
