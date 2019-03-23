package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Loads a file into the Editor when clicked through the use of methods in context.
 */
public class FileLoad extends ButtonControl{
    /**
     * @param context where this button is located
     */
    public FileLoad(FrontendController context) {
        super("FileLoad", context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.loadFile();
    }
}
