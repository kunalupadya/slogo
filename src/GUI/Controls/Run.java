package GUI.Controls;

import GUI.Modules.Editor;
import javafx.scene.image.Image;

public class Run extends Control {
    private Editor context;

    protected Run(Editor context) {
        super(new Image(Editor.class.getResourceAsStream("/images/play.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.run();
    }
}
