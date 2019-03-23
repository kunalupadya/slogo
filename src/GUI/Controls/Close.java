package GUI.Controls;

import GUI.Modules.Module;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Button to close individual modules. Needs an associated method in context.
 */
public class Close extends ButtonControl {
    private Module context;
    private Class clazz;

    /**
     * @param context where this button is located
     */
    public Close(Module context, Class clazz) {
        super(new Image(Module.class.getResourceAsStream("/images/close.png")), null);
        myImage.setFitHeight(10.0);
        myImage.setFitWidth(10.0);
        this.myButton.setGraphic(myImage);
        this.myButton.getStyleClass().add("close-button");
        this.context = context;
        this.clazz = clazz;
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> context.close(clazz);
    }
}
