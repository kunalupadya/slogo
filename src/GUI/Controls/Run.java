package GUI.Controls;

import GUI.FrontendController;
import GUI.Modules.Editor;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Runs the code currently in the editor module.
 */
public class Run extends ButtonControl {
    /**
     * @param context where this button is located
     */
    public Run(FrontendController context) {
        super("Run", context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.run();
    }
}
