package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.image.Image;

public class Undo extends Control {
    private FrontendController context;

    public Undo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/undo.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.undo();
    }
}
