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
     * @param myScene
     * @param context
     */
    public WindowLayout(Scene myScene, Controller context) {
        this.context = context;

        var borderPane = new BorderPane();
        var rightBorderPane = new BorderPane();

        rightBorderPane.setTop(new GUI.Windows.AvailableVars());
        rightBorderPane.setBottom(new GUI.Windows.Editor());

        borderPane.setLeft(new GUI.Windows.GraphicsArea());
        borderPane.setRight(rightBorderPane);
        borderPane.setBottom(new GUI.Windows.Console());

        myContainer = borderPane;
    }

    public BorderPane getContainer() {
        return myContainer;
    }
}
