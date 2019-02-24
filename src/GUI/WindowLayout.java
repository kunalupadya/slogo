package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;

import Main.Controller;

import static Main.Controller.Aller_Bd;
import static Main.Controller.Aller_Lt;
import static Main.Controller.Aller_LtIt;

/**
 * TODO: text should not be hardcoded; we will need to modify Main.TextMaker and add a config file
 *
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro
 */
public class WindowLayout {
    private Group myContainer;
    private Controller context;

    /**
     * TODO: add JavaDoc
     *
     * @param myScene
     * @param context
     */
    public WindowLayout(Scene myScene, Controller context) {
        this.context = context;

        var initLayout = new Group();
    }
}
