package GUI.Controls;

import GUI.FrontendController;
import GUI.Modules.Editor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Runs the code currently in the editor module.
 */
public class Run extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public Run(FrontendController context) {
        super(new Image(Editor.class.getResourceAsStream("/images/run.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.run();
    }
}
