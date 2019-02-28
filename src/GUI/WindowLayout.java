package GUI;

import GUI.Controls.*;
import GUI.Modules.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

import Main.Controller;

import java.awt.image.ColorConvertOp;

/**
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro
 */
public class WindowLayout {
    private BorderPane myContainer;
    private Editor editor;
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
        editor = new Editor(200, 200);

        var rightBorderPane = new BorderPane();
        var varsAndCommands = new VBox();

        varsAndCommands.getChildren().addAll(new GUI.Modules.AvailableVars(200, 200).getContent(),
                new GUI.Modules.UserCommands(200, 200).getContent());

        rightBorderPane.setTop(new GUI.Modules.UserCommands(200, 200).getContent());
        rightBorderPane.setCenter(editor.getContent());

        root.setTop(returnButtons());
        root.setCenter(new GUI.Modules.GraphicsArea(400, 400).getContent());
        root.setRight(rightBorderPane);
        root.setBottom(new GUI.Modules.Console(600, 50).getContent());

        myContainer = root;
    }

    private HBox returnButtons() {
        var buttonHandler = new HBox();

        buttonHandler.setStyle("-fx-background-color: #808080");
        buttonHandler.setMinWidth(600);
        buttonHandler.setMinHeight(30);

        openHelp = new OpenHelp(this);
        openHelp.getButton().setTooltip(new Tooltip("Open Help"));

        switchLanguages = new SwitchLanguages(this);
        switchLanguages.getButton().setTooltip(new Tooltip("Switch Languages"));

        setPenColor = new SetPenColor().getColorPicker();
        setPenColor.setTooltip(new Tooltip("Set Pen Color"));

        setBackgroundColor = new SetBackgroundColor().getColorPicker();
        setBackgroundColor.setTooltip(new Tooltip("Set Background Color"));

        undo = new Undo(this);
        undo.getButton().setLayoutX(200);
        undo.getButton().setTooltip(new Tooltip("Undo"));

        redo = new Redo(this);
        redo.getButton().setTooltip(new Tooltip("Redo"));

        stopExecution = new StopExecution(this);
        stopExecution.getButton().setTooltip(new Tooltip("Stop Execution"));

        run = new Run(editor);
        run.getButton().setTooltip(new Tooltip("Run"));

        var leftButtons = new HBox(openHelp.getButton(), switchLanguages.getButton(),
                setBackgroundColor, setPenColor);
        leftButtons.setPadding(new Insets(5, 5, 5, 5));
        leftButtons.setSpacing(5);
        leftButtons.setAlignment(Pos.CENTER_LEFT);

        var rightButtons = new HBox(undo.getButton(), redo.getButton(), stopExecution.getButton(), run.getButton());
        rightButtons.setPadding(new Insets(5, 5, 5, 5));
        rightButtons.setSpacing(5);
        rightButtons.setAlignment(Pos.CENTER_RIGHT);

        buttonHandler.getChildren().addAll(leftButtons, rightButtons);
        buttonHandler.setHgrow(rightButtons, Priority.ALWAYS);
        return buttonHandler;
    }

    public BorderPane getContainer() {
        return myContainer;
    }

    public void redo() {}
}
