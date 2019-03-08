package GUI.Controls;

import GUI.Modules.Editor;
import javafx.scene.image.Image;

public class Run extends ButtonControl {
    private Editor context;

    public Run(Editor context) {
        super(new Image(Editor.class.getResourceAsStream("/images/run.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.run();
    }
}
