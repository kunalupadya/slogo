package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.image.Image;

public class StopExecution extends Control {
    private WindowLayout context;

    public StopExecution(WindowLayout context) {
        super(new Image(WindowLayout.class.getResourceAsStream("/images/stop.png")));
    }

    @Override
    protected void action() {

    }
}
