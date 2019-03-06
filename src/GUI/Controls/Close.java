package GUI.Controls;

import GUI.Modules.Module;
import javafx.scene.image.Image;

import java.io.File;

public class Close extends Control{
    private Module context;
    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public Close(Module context) {
        super(new Image(Module.class.getResourceAsStream("/images/close.png")));
        img.setFitHeight(10.0);
        img.setFitWidth(10.0);
        this.button.setGraphic(img);
        this.button.getStyleClass().add("close-button");
        this.context = context;
    }

    @Override
    protected void action() {
        context.close();
    }
}
