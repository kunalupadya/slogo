package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.image.Image;

public class StopExecution extends Control {
    private FrontendController context;

    public StopExecution(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/stop.png")));
    }

    @Override
    protected void action() {

    }
}
