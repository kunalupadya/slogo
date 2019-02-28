package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.image.Image;

public class OpenHelp extends Control {
    private WindowLayout context;

    public OpenHelp(WindowLayout context) {
        super(new Image(WindowLayout.class.getResourceAsStream("/images/help.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.redo();
    }
}
