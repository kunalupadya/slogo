package GUI;

import GUI.Controls.*;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;

import Main.Controller;
import Main.TextMaker;

import java.awt.image.ColorConvertOp;

/**
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro
 */
public class WindowLayout {
    private BorderPane myContainer;
    private Control openHelp, redo, run, switchLanguages, undo, stopExecution;
    private ColorPicker setBackgroundColor, setPenColor;
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

    private HBox returnButtons() {
        var buttonHandler = new HBox();

        buttonHandler.setStyle("-fx-background-color: #808080");
        buttonHandler.setPadding(new Insets(5, 5, 5, 5));
//        openHelp = new OpenHelp(this);
//        openHelp.getButton().setLayoutX(300);
//        openHelp.getButton().setLayoutY(0);
//        openHelp.getButton().setTooltip(new Tooltip("Open Help"));

        switchLanguages = new SwitchLanguages(this);
        switchLanguages.getButton().setTooltip(new Tooltip("Switch Languages"));

        undo = new Undo(this);
        undo.getButton().setTooltip(new Tooltip("Undo"));

        stopExecution = new StopExecution(this);
        stopExecution.getButton().setTooltip(new Tooltip("Stop Execution"));


        setPenColor = new SetPenColor().getColorPicker();
        setPenColor.setTooltip(new Tooltip("Set Pen Color"));

        setBackgroundColor = new SetBackgroundColor().getColorPicker();
        setBackgroundColor.setTooltip(new Tooltip("Set Background Color"));


        buttonHandler.getChildren().addAll(switchLanguages.getButton(), stopExecution.getButton(), undo.getButton(),
                setPenColor, setBackgroundColor);
        return buttonHandler;
    }

    public BorderPane getContainer() {
        return myContainer;
    }

    public void redo() {}
}
