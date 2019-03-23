package GUI.Controls;

import GUI.Modules.Editor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Runs the code currently in the editor module.
 */
public class Run extends ButtonControl {
    private Editor context;

    /**
     * @param context where this button is located
     */
    public Run(Editor context) {
        super(new Image(Editor.class.getResourceAsStream("/images/run.png")));
        this.context = context;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> {
            context.run();
        };
    }
}
