package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class FileLoad extends ButtonControl{
    /**
     * TODO: finish JavaDoc
     *
     * @param context
     */
    public FileLoad(FrontendController context) {
        super(new Image(FrontendController.class.getResourceAsStream("/images/loadFile.png")), context);
    }

    @Override
    protected EventHandler<MouseEvent> action() {
        return event -> myContext.loadFile();
    }
}
