package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.image.Image;

public class SwitchLanguages extends Control {
    private WindowLayout context;

    public SwitchLanguages(WindowLayout context) {
        super(new Image(WindowLayout.class.getResourceAsStream("/images/language.png")));
        this.context = context;
    }

    @Override
    protected void action() {

    }
}
