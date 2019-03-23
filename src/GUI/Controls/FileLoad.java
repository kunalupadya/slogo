package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Loads a file into the Editor when clicked through the use of methods in context.
 */
public class FileLoad extends ButtonControl{
    private FrontendController context;

    /**
     * @param context where this button is located
     */
    public FileLoad(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/loadFile.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.loadFile();
    }
}
