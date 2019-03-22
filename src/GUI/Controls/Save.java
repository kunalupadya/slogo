package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to save text currently in the editor module
 */
public class Save extends ButtonControl {
    private FrontendController context;

    /**
     * @param context where this button is located
     */
    public Save(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/save.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.savePreferencesFile();
    }
}

