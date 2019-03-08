package GUI.Controls;

import GUI.Modules.Editor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Run extends ButtonControl {
    private Editor context;

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
