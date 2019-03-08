package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Save extends ButtonControl {
    FrontendController context;

    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public Save(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/save.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.save();
    }
}
