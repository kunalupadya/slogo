package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Saves the current text in Editor to a txt file through the use of methods in context.
 */
public class FileSave extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public FileSave(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/saveFile.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.saveToFile();
    }
}
