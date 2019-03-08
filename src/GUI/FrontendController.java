package GUI;

import GUI.Controls.*;
import GUI.Modules.*;
import GUI.Modules.Console;
import GraphicsBackend.Pen;
import GraphicsBackend.Turtle;
import Main.BackendController;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
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
    private HBox buttonHandler;
    private Group helpGroup;
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
    private ButtonControl redo, run, undo, stopExecution, setTurtleImage, save;
    private ColorPicker setBackgroundColor, setPenColor;
    private BackendController backendController;
    private String defaultLanguage = "English";
    private List<Turtle> turtles;
    private List<String> moduleList;
    private ResourceBundle myModuleContainer, myModulePosition, myModuleLabels;
    private int editorWidth = 200;
    private int editorHeight = 210;
    private int availableVarsWidth = 200;
    private int availableVarsHeight = 105;
    private int userCommandsWidth = 200;
    private int userCommandsHeight = 105;
    private int consoleWidth = 800;
    private int consoleHeight = 100;
    private int graphicsAreaWidth = 400;
    private int graphicsAreaHeight = 420;
    private int palettesWidth = 200;
    private int palettesHeight = 210;
    private int currentStateWidth = 200;
    private int currentStateHeight = 210;
    private String moduleContainer = "/buttonProperties/ModuleContainer";
    private String modulePosition = "/buttonProperties/ModulePosition";
    private String moduleLabels = "/moduleProperties/ModuleLabel";
    private String editorPath = "data/editorFiles/";
    private Boolean checkSimulation = false;

    /**
     * TODO: add JavaDoc
     *
     * @param root
     */
    public FrontendController(BorderPane root, Stage stage) {
        this.myStage = stage;
        this.myContainer = root;
        this.myModuleLabels = ResourceBundle.getBundle(moduleLabels);
        this.myModuleContainer = ResourceBundle.getBundle(moduleContainer);
        this.myModulePosition = ResourceBundle.getBundle(modulePosition);

        this.editor = new Editor(editorWidth, editorHeight, myModuleLabels.getString("Editor"), this);
        this.availableVars = new AvailableVars(availableVarsWidth, availableVarsHeight,  myModuleLabels.getString("AvailableVars"),this);
        this.userCommands = new UserCommands(userCommandsWidth, userCommandsHeight, myModuleLabels.getString("UserCommands"), this);
        this.console = new Console(consoleWidth, consoleHeight, myModuleLabels.getString("Console"), this);
        this.graphicsArea = new GraphicsArea(graphicsAreaWidth, graphicsAreaHeight, myModuleLabels.getString("GraphicsArea"), this);
        this.palettes = new Palettes(palettesWidth, palettesHeight, myModuleLabels.getString("Palettes"), this);
        this.currentState = new CurrentState(currentStateWidth, currentStateHeight, myModuleLabels.getString("CurrentState"), this);

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
        buttonHandler = new HBox();

        buttonHandler.setId("buttonHandler");
        buttonHandler.setMaxWidth(800);
        buttonHandler.setMaxHeight(30);

        openHelp = new OpenHelp(this);
        openHelp.getButton().setTooltip(new Tooltip("Help"));

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

        var leftButtons = new HBox(openHelp.getButton(), switchLanguages.getButton(),
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
                setTurtleImage.setImage(chosenFile, setTurtleImage.getButton());
                for (Turtle turtle: backendController.getMyTurtles()){
                    turtle.setTurtleImage(new Image(new FileInputStream(chosenFile.getPath())));
                }
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
            if (turtle.isTurtleVisible()) {
                ImageView turtleImage = turtle.getAdjustedTurtleImageView(0,0);
                Boolean isTurtleActive = turtle.getIsTurtleActive();
                turtleImages.add(turtleImage);
                turtleActives.add(isTurtleActive);
            }
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

    public void addToConsole(String commandString) {
        console.addToConsole(commandString);
    }

    public void consoleShowError(String errorString) {
        //errorString is truly coming from BackEnd though
        console.showError(errorString);
    }

    public void getAvailableVars() {
        Set<String> availableVarsList = backendController.getAllVariables();
        availableVars.setList(availableVarsList);
    }

    public void getUserCommands() {
        Set<String> userCommandsList = backendController.getAllCommands();
        userCommands.setList(userCommandsList);
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

    public void saveToFile(String filename) {
        ObservableList<CharSequence> paragraph = editor.getText();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            //Replace Editor1 with filename parameter
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(editorPath + filename + ".txt")));
            while (iter.hasNext()) {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
        }
        catch (IOException e)
        {
            consoleShowError("Cannot write invalid text into a file");
        }
    }

    public void loadFile(String filename) {
        try
        {
            Scanner s = new Scanner(new File(editorPath + filename + ".txt"));
            editor.readText(s);
        }
        catch (FileNotFoundException e)
        {
            consoleShowError("File " + filename + ".txt does not exist");
        }
    }

    public void changeLanguage(String language) {
        backendController.setCommandLanguage(language);
        moveTurtle.setResourceBundle(language);
    }

    public void runSimulation() {
        backendController.parseAndRun("go");
    }

    public void step() {
        setGraphicsArea();
        setCurrentState();
        getPalettes();
        getAvailableVars();
        getUserCommands();
        if (checkSimulation) {
            runSimulation();
        }
    }

    /**
     * TODO: Use a properties file to be able to setNode to null
     * @param clazz
     */
    public void close(Class<?> clazz) {
        String className = clazz.getSimpleName();
        moduleList.remove(className);

        closeModule(myModuleContainer.getString(className), myModulePosition.getString(className));

        if (clazz.equals(console.getClass())) {
            myStage.setMaxHeight(485);
        }
        else if ((clazz.equals(palettes.getClass()) && (! moduleList.contains("CurrentState")))
                || (clazz.equals(currentState.getClass()) && (! moduleList.contains("Palettes")))) {
            myContainer.setLeft(null);
            buttonHandler.setMinWidth(600);
            buttonHandler.setMaxWidth(600);
            console.getContent().setMinWidth(600);
            console.getContent().setMaxWidth(600);
            if (myStage.getWidth() != 600) {
                myStage.setMaxWidth(600);
            }
        }
        else if ((!moduleList.contains("Editor") && !moduleList.contains("AvailableVars") && !moduleList.contains("UserCommands"))) {
            myContainer.setRight(null);
            buttonHandler.setMinWidth(600);
            buttonHandler.setMaxWidth(600);
            console.getContent().setMinWidth(600);
            console.getContent().setMaxWidth(600);
            if (myStage.getWidth() != 600) {
                myStage.setMaxWidth(600);
            }
        }
    }

    public void undo(){
        backendController.undo();
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

    public void showHelp(String helpPath) {
        helpGroup = new Group();

        Rectangle dialogBox = new Rectangle(0, 0, 400, 400);
        dialogBox.setEffect(new DropShadow(25, 0, 0, Color.web("#333333")));
        dialogBox.setArcWidth(20);
        dialogBox.setArcHeight(20);
        dialogBox.setFill(Color.WHITE);

        TextArea help = new TextArea();
        help.setEditable(false);
        help.setLayoutY(50);
        help.setMaxWidth(400);
        help.setPrefHeight(350);

        double originY = myStage.getScene().getHeight()/2 - dialogBox.getLayoutBounds().getHeight()/2 - 15;
        double originX = myStage.getScene().getWidth()/2 - dialogBox.getLayoutBounds().getWidth()/2;

        ButtonControl close = new CloseHelp(this);
        close.getButton().setLayoutX(dialogBox.getWidth() - 50);
        close.getButton().setLayoutY(10);
        close.getButton().setCursor(Cursor.HAND);
        close.getButton().setTooltip(new Tooltip("Close Menu"));

        Scanner s = new Scanner(this.getClass().getResourceAsStream(helpPath));
        while (s.hasNextLine()) {
            help.appendText(s.nextLine() + "\n");
        }

        helpGroup.getChildren().addAll(dialogBox, close.getButton(), help);

        helpGroup.setLayoutY(originY);
        helpGroup.setLayoutX(originX);

        myContainer.getChildren().add(helpGroup);
    }

    public void closeHelp() {
        myContainer.getChildren().remove(helpGroup);
        helpGroup = null;
    }

    public void save() {}
}
