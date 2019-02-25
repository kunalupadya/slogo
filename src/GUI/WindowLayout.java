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

        rightBorderPane.setTop(new GUI.Windows.AvailableVars());
        rightBorderPane.setBottom(new GUI.Windows.Editor());

        root.setLeft(new GUI.Windows.GraphicsArea());
        root.setRight(rightBorderPane);
        root.setBottom(new GUI.Windows.Console());

        myContainer = root;
    }

    public BorderPane getContainer() {
        return myContainer;
    }
}
