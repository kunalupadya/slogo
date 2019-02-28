package GUI;

import GUI.Controls.*;
import GUI.Modules.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro
 */
public class WindowLayout {
    private Stage myStage;
    private BorderPane myContainer;
    private Editor editor;
    private OpenHelp openHelp;
    private Control redo, run, switchLanguages, undo, stopExecution, setTurtleImage;;
    private ColorPicker setBackgroundColor, setPenColor;

    /**
     * TODO: add JavaDoc
     *
     * @param root
     */
    public WindowLayout(BorderPane root, Stage stage) {
        myStage = stage;
        editor = new Editor(200, 200);

        var rightBorderPane = new BorderPane();

        rightBorderPane.setTop(new GUI.Modules.AvailableVars(200, 100).getContent());
        rightBorderPane.setCenter(new GUI.Modules.UserCommands(200, 100).getContent());
        rightBorderPane.setBottom(editor.getContent());

        root.setTop(returnButtons());
        root.setBottom(new GUI.Modules.Console(600, 100).getContent());
        root.setCenter(new GUI.Modules.GraphicsArea(400, 400).getContent());
        root.setRight(rightBorderPane);

        myContainer = root;
    }

    private HBox returnButtons() {
        var buttonHandler = new HBox();

        buttonHandler.setStyle("-fx-background-color: #808080");
        buttonHandler.setMinWidth(600);
        buttonHandler.setMinHeight(30);

        openHelp = new OpenHelp(this);
        openHelp.getHyperlink().setTooltip(new Tooltip("Help"));

        setTurtleImage = new SetTurtleImage(this);
        setTurtleImage.getButton().setTooltip(new Tooltip("Set Turtle Image"));

        switchLanguages = new SwitchLanguages(this);
        switchLanguages.getButton().setTooltip(new Tooltip("Switch Languages"));

        setPenColor = new SetPenColor().getColorPicker();
        setPenColor.setTooltip(new Tooltip("Set Pen Color"));

        setBackgroundColor = new SetBackgroundColor().getColorPicker();
        setBackgroundColor.setTooltip(new Tooltip("Set Background Color"));

        undo = new Undo(this);
        undo.getButton().setTooltip(new Tooltip("Undo"));

        redo = new Redo(this);
        redo.getButton().setTooltip(new Tooltip("Redo"));

        stopExecution = new StopExecution(this);
        stopExecution.getButton().setTooltip(new Tooltip("Stop Execution"));

        run = new Run(editor);
        run.getButton().setTooltip(new Tooltip("Run"));

        var leftButtons = new HBox(openHelp.getHyperlink(), switchLanguages.getButton(),
                setBackgroundColor, setPenColor, setTurtleImage.getButton());
        leftButtons.setPadding(new Insets(5, 5, 5, 5));
        leftButtons.setSpacing(5);
        leftButtons.setAlignment(Pos.CENTER_LEFT);

        var rightButtons = new HBox(undo.getButton(), redo.getButton(), stopExecution.getButton(), run.getButton());
        rightButtons.setPadding(new Insets(5, 5, 5, 5));
        rightButtons.setSpacing(5);
        rightButtons.setAlignment(Pos.CENTER_RIGHT);

        buttonHandler.getChildren().addAll(leftButtons, rightButtons);
        return buttonHandler;
    }

    public BorderPane getContainer() {
        return myContainer;
    }

    public void handleSetTurtleImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("data/turtles"));
        File chosenFile = fileChooser.showOpenDialog(myStage);
        if (chosenFile != null) {
            try {
                setTurtleImage.setImage(chosenFile);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                alert.showAndWait();
            }
        }
    }
}
