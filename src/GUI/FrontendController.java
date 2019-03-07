package GUI;

import GUI.Controls.*;
import GUI.Modules.*;
import GraphicsBackend.Pen;
import GraphicsBackend.Turtle;
import Main.BackendController;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Class will contain the initial layout for the Window
 *
 * @author Januario Carreiro & David Liu
 */
public class FrontendController {
    private Stage myStage;
    private BorderPane myContainer, leftBorderPane, rightBorderPane;
    private Editor editor;
    private AvailableVars availableVars;
    private UserCommands userCommands;
    private GraphicsArea graphicsArea;
    private Palettes palettes;
    private CurrentState currentState;
    private Console console;
    private OpenHelp openHelp;
    private MoveTurtle moveTurtle;
    private SwitchLanguages switchLanguages;
    private Control redo, run, undo, stopExecution, setTurtleImage, save;
    private ColorPicker setBackgroundColor, setPenColor;
    private BackendController backendController;
    private String defaultLanguage = "English";
    private List<Turtle> turtles;
    private List<String> moduleList;
    private ResourceBundle myModuleContainer, myModulePosition;

    /**
     * TODO: add JavaDoc
     *
     * @param root
     */
    public FrontendController(BorderPane root, Stage stage) {
        this.myStage = stage;
        this.myContainer = root;

        this.editor = new Editor(200, 210, this);
        this.availableVars = new AvailableVars(200, 105, this);
        this.userCommands = new UserCommands(200, 105, this);
        this.console = new Console(800, 100, this);
        this.graphicsArea = new GraphicsArea(400, 420, this);
        this.palettes = new Palettes(200, 210, this);
        this.currentState = new CurrentState(200, 210, this);

        this.myModuleContainer = ResourceBundle.getBundle("/buttonProperties/ModuleContainer");
        this.myModulePosition = ResourceBundle.getBundle("/buttonProperties/ModulePosition");
        this.moduleList = new ArrayList<>();

        Enumeration<String> itemEnum = myModuleContainer.getKeys();

        while(itemEnum.hasMoreElements()) {
            moduleList.add(itemEnum.nextElement());
        }

        leftBorderPane = new BorderPane();
        leftBorderPane.setTop(palettes.getContent());
        leftBorderPane.setCenter(currentState.getContent());

        rightBorderPane = new BorderPane();
        rightBorderPane.setTop(availableVars.getContent());
        rightBorderPane.setCenter(editor.getContent());
        rightBorderPane.setBottom(userCommands.getContent());

        myContainer.setTop(returnButtons());
        myContainer.setBottom(console.getContent());
        myContainer.setLeft(leftBorderPane);
        myContainer.setCenter(graphicsArea.getContent());
        myContainer.setRight(rightBorderPane);

        setBackgroundColor(Color.LIGHTBLUE);
    }

    private HBox returnButtons() {
        var buttonHandler = new HBox();

        buttonHandler.setId("buttonHandler");
        buttonHandler.setMaxWidth(800);
        buttonHandler.setMaxHeight(30);

        openHelp = new OpenHelp(this);
        openHelp.getHyperlink().setTooltip(new Tooltip("Help"));

        setPenColor = new SetPenColor().getColorPicker();
        setPenColor.setTooltip(new Tooltip("Set Pen Color"));

        setBackgroundColor = new SetBackgroundColor(this).getColorPicker();
        setBackgroundColor.setTooltip(new Tooltip("Set Background Color"));

        setTurtleImage = new SetTurtleImage(this);
        setTurtleImage.getButton().setTooltip(new Tooltip("Set Turtle Image"));

        switchLanguages = new SwitchLanguages(this);
        switchLanguages.getButton().setTooltip(new Tooltip("Switch Languages"));

        save = new Save(this);
        save.getButton().setTooltip(new Tooltip("Save"));

        moveTurtle = new MoveTurtle(this);
        moveTurtle.getButton().setTooltip(new Tooltip("Move Turtle"));

        undo = new Undo(this);
        undo.getButton().setTooltip(new Tooltip("Undo"));

        redo = new Redo(this);
        redo.getButton().setTooltip(new Tooltip("Redo"));

        stopExecution = new StopExecution(this);
        stopExecution.getButton().setTooltip(new Tooltip("Stop Execution"));

        run = new Run(editor);
        run.getButton().setTooltip(new Tooltip("Run"));

        var leftButtons = new HBox(openHelp.getHyperlink(), switchLanguages.getButton(),
                setBackgroundColor, setPenColor, setTurtleImage.getButton(), save.getButton());
        leftButtons.getStyleClass().add("button-container");

        var padding = new Region();

        var rightButtons = new HBox(moveTurtle.getButton(), undo.getButton(), redo.getButton(), stopExecution.getButton(), run.getButton());
        rightButtons.getStyleClass().add("button-container");

        buttonHandler.setHgrow(padding, Priority.ALWAYS);
        buttonHandler.getChildren().addAll(leftButtons, padding, rightButtons);
        return buttonHandler;
    }

    public BorderPane getContainer() {
        return myContainer;
    }

    /**
     * TODO: make it possible to set image of any button through reflection
     */
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

    public void setBackendController(BackendController backendController) {
        this.backendController = backendController;
        changeLanguage(defaultLanguage);
        setGraphicsArea();
    }

    public void setGraphicsArea(){
        List<Line> lines = backendController.getMyGrid().getAllObjects();
        turtles = backendController.getMyTurtles();
        List<ImageView> turtleImages = new ArrayList<>();
        List<Boolean> turtleActives = new ArrayList<>();
        for (Turtle turtle:turtles) {
            ImageView turtleImage = turtle.getAdjustedTurtleImageView(0,0);
            Boolean isTurtleActive = turtle.getIsTurtleActive();
            turtleImages.add(turtleImage);
            turtleActives.add(isTurtleActive);
        }
        graphicsArea.setVariables(lines, turtleImages, turtleActives);
    }

    public void setBackgroundColor(Paint color) {
        graphicsArea.setColor(color);
    }

    public void sendCommandString(String commandString) {
        backendController.parseAndRun(commandString);
    }

    public void switchTurtleActive(int turtleNumber) {
        if (turtles.get(turtleNumber).getIsTurtleActive()) {
            turtles.get(turtleNumber).setTurtleActive(false);
        }
        else {
            turtles.get(turtleNumber).setTurtleActive(true);
        }
    }

//    public void addToPrevCommands(String commandString) {
//        console.addToHistory(commandString);
//    }

    public void addToConsole(String commandString) {
        console.addToConsole(commandString);
    }

    public void consoleShowError(String errorString) {
        //errorString is truly coming from BackEnd though
        console.showError(errorString);
    }

    public void getAvailableVars(List<String> availableVarsList) {
        //availableVarsList also truly coming from BackEnd though
        availableVars.setAvailableVars(availableVarsList);
    }

    public void getUserCommands(List<String> userCommandsList) {
        //userCommandsList also truly coming from BackEnd though
        userCommands.setUserCommands(userCommandsList);
    }

    public void setCurrentState() {
        turtles = backendController.getMyTurtles();
        int counter = 0;
        List<Integer> ids = new ArrayList<>();
        List<Double> xPositions = new ArrayList<>();
        List<Double> yPositions = new ArrayList<>();
        List<Color> penColors = new ArrayList<>();
        List<Double> angles = new ArrayList<>();
        List<Boolean> penUp = new ArrayList<>();
        //Or Is It Pen Width???
        List<Integer> penSize = new ArrayList<>();
        for (Turtle turtle: turtles) {
            Pen pen = turtle.getMyPen();
            ids.add(counter);
            xPositions.add(turtle.getxPos());
            yPositions.add(turtle.getyPos());
            angles.add(turtle.getMyAngle());
            penColors.add(pen.getMyPenColor());
            penUp.add(pen.getPenUp());
            penSize.add(pen.getPenSize());
            counter++;
        }
        currentState.getTurtleAndPens(ids, xPositions, yPositions, angles, penColors, penUp, penSize);
    }

    public void getPalettes() {
        Color[] paletteIndices = backendController.getColorPalette();
        palettes.setPalettes(paletteIndices);
    }

    public void changeLanguage(String language) {
        backendController.setCommandLanguage(language);
    }

    public void step() {
        setGraphicsArea();
        setCurrentState();
        getPalettes();
    }

    /**
     * TODO: Use a properties file to be able to setNode to null
     * @param clazz
     */
    public void close(Class<?> clazz) {
        String className = clazz.getSimpleName();
        moduleList.remove(className);

        closeModule(myModuleContainer.getString(className), myModulePosition.getString(className));
    }

    private void closeModule(String modulePane, String modulePosition) {
        switch(modulePane) {
            case "myContainer":
                try {
                    Method m = myContainer.getClass().getDeclaredMethod(modulePosition, Node.class);
                    m.invoke(myContainer, (Object) null);
                } catch (Exception e) {
                    System.out.println("Error Occurred when Removing Module");
                }
                break;
            case "leftBorderPane":
                try {
                    Method m = leftBorderPane.getClass().getMethod(modulePosition, Node.class);
                    m.invoke(leftBorderPane, (Object) null);
                } catch (Exception e) {
                    System.out.println("Error Occurred when Removing Module");
                }
                break;
            case "rightBorderPane":
                try {
                    Method m = rightBorderPane.getClass().getMethod(modulePosition, Node.class);
                    m.invoke(rightBorderPane, (Object) null);
                } catch (Exception e) {
                    System.out.println("Error Occurred when Removing Module");
                }
                break;
        }
    }

    public void save() {}
}
