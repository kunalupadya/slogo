package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.image.Image;

public class Redo extends ButtonControl {
    private FrontendController context;

    public Redo(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/redo.png")));
        this.context = context;
    }

    @Override
    protected void action() {

    }
}
