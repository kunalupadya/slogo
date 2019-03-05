package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.image.Image;

public class Save extends Control{
    FrontendController context;

    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public Save(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/save.png")));
        this.context = context;
    }

    @Override
    protected void action() {
        context.save();
    }
}
