package GUI;

import GUI.Controls.Control;
import GUI.Controls.OpenHelp;
import GUI.Controls.Run;
import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;

import Main.Controller;
import Main.TextMaker;

/**
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro
 */
public class WindowLayout {
    private BorderPane myContainer;
    private Control openHelp, redo, run, setBackgroundColor;
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

        rightBorderPane.setCenter(new GUI.Modules.AvailableVars(200, 200).getContent());
        rightBorderPane.setBottom(new GUI.Modules.Editor(200, 200).getContent());

        root.setTop(returnButtons());
        root.setCenter(new GUI.Modules.GraphicsArea(400, 400).getContent());
        root.setRight(rightBorderPane);
        root.setBottom(new GUI.Modules.Console(600, 50).getContent());

        myContainer = root;
    }

    private Group returnButtons() {
        var buttonHandler = new Group();

        openHelp = new OpenHelp(this);
        openHelp.getButton().setLayoutX(300);
        openHelp.getButton().setLayoutY(0);
        openHelp.getButton().setTooltip(new Tooltip("Open Help"));

        buttonHandler.getChildren().addAll(openHelp.getButton());
        return buttonHandler;
    }

    public BorderPane getContainer() {
        return myContainer;
    }

    public void redo() {}
}
