package GUI;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import Main.Controller;

/**
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro
 */
public class WindowLayout {
    private BorderPane myContainer;
    private Controller context; // TODO: Will we need context?

    /**
     * TODO: add buttons
     * TODO: add JavaDoc
     *
     * @param root
     * @param context
     */
    public WindowLayout(BorderPane root, Controller context) {
        this.context = context;

        var rightBorderPane = new BorderPane();

        rightBorderPane.setTop(new GUI.Modules.AvailableVars(200, 200).getContent());
        rightBorderPane.setBottom(new GUI.Modules.Editor(200, 200).getContent());

        root.setCenter(new GUI.Modules.GraphicsArea(400, 400).getContent());
        root.setRight(rightBorderPane);
        root.setBottom(new GUI.Modules.Console(600, 100).getContent());

        myContainer = root;
    }

    public BorderPane getContainer() {
        return myContainer;
    }
}
