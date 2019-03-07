package GUI.Controls;

import GUI.Modules.Module;
import javafx.scene.image.Image;

public class Close extends Control{
    private Module context;
    private Class clazz;
    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public Close(Module context, Class clazz) {
        super(new Image(Module.class.getResourceAsStream("/images/close.png")));
        img.setFitHeight(10.0);
        img.setFitWidth(10.0);
        this.button.setGraphic(img);
        this.button.getStyleClass().add("close-button");
        this.context = context;
        this.clazz = clazz;
    }

    @Override
    protected void action() {
        context.close(clazz);
    }
}
