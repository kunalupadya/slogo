package GUI;

import GUI.Controls.*;
import GUI.Modules.*;
import GraphicsBackend.ImmutablePen;
import GUI.Modules.Console;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
    private Editor editor;
    private AvailableVars availableVars;
    private UserCommands userCommands;
    private GraphicsArea graphicsArea;
    private Palettes palettes;
    private CurrentState currentState;
    private Console console;
    private MenuButtonControl openHelp, moveTurtle, switchLanguages, penThickess;
    private ButtonControl redo, run, undo, setTurtleImage, save, load, saveFile, loadFile, penState;
    private ColorPicker BackgroundColor, PenColor;
    private TextField backgroundColor, penColor, numTurtles, language, fileName;
    private BackendController backendController;
    private String defaultLanguage = "English";
    private List<Turtle> turtles;
    private List<String> moduleList;
    private ResourceBundle myModuleContainer, myModulePosition, myModuleLabels, myPreferences;
    private int editorWidth = 200;
    private int editorHeight = 210;
    private int availableVarsWidth = 200;
    private int availableVarsHeight = 105;
    private int userCommandsWidth = 200;
    private int userCommandsHeight = 105;
    private int stageWidth = 800;
    private int stageReducedWidth = 600;
    private int stageReducedHeight = 485;
    private int consoleHeight = 100;
    private int buttonHandlerHeight = 30;
    private int graphicsAreaWidth = 400;
    private int graphicsAreaHeight = 420;
    private int palettesWidth = 200;
    private int palettesHeight = 210;
    private int currentStateWidth = 200;
    private int currentStateHeight = 210;
    private int rectangleWidth = 400;
    private int rectangleHeight = 300;
    private int textFieldAdjustedY = 30;
    private int textFieldWidth = 340;
    private int textFieldLayoutX = 30;
    private int textFieldLayoutY = 60;
    private int helpPrefHeight = 350;
    private int rectangleArc = 20;
    private int dropShadowPosition = 25;
    private int closeButtonLayoutY = 10;
    private int saveButtonLayoutY = 250;
    private int positionToCenter = 15;
    private int positionToArrangeLeft = 50;
    private int helpLayoutY = 50;
    private String moduleContainer = "/buttonProperties/ModuleContainer";
    private String modulePosition = "/buttonProperties/ModulePosition";
    private String moduleLabels = "/moduleProperties/ModuleLabel";
    private String preferences = "/moduleProperties/UserPreferences";
    private String editorPath = "data/editorFiles/";
    private String preferencesPath = "data/saveStates/";
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
        this.myPreferences = ResourceBundle.getBundle(preferences);

        this.editor = new Editor(editorWidth, editorHeight, myModuleLabels.getString("Editor"), this);
        this.availableVars = new AvailableVars(availableVarsWidth, availableVarsHeight,  myModuleLabels.getString("AvailableVars"),this);
        this.userCommands = new UserCommands(userCommandsWidth, userCommandsHeight, myModuleLabels.getString("UserCommands"), this);
        this.console = new Console(stageWidth, consoleHeight, myModuleLabels.getString("Console"), this);
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
        buttonHandler.setMaxSize(stageWidth, buttonHandlerHeight);

        openHelp = new OpenHelp(this);
        openHelp.getButton().setTooltip(new Tooltip("Help"));

        BackgroundColor = new SetBackgroundColor(this).getColorPicker();
        BackgroundColor.setTooltip(new Tooltip("Set Background Color"));

        PenColor = new SetPenColor(this).getColorPicker();
        PenColor.setTooltip(new Tooltip("Set Pen Color"));

        penThickess = new SetPenThickness(this);
        penThickess.getButton().setTooltip(new Tooltip("Set Pen Thickness"));

        penState = new SetPenState(this);
        penState.getButton().setTooltip(new Tooltip("Set Pen State"));

        setTurtleImage = new SetTurtleImage(this);
        setTurtleImage.getButton().setTooltip(new Tooltip("Set Turtle Image"));

        switchLanguages = new SwitchLanguages(this);
        switchLanguages.getButton().setTooltip(new Tooltip("Switch Languages"));

        save = new PropertiesSave(this);
        save.getButton().setTooltip(new Tooltip("Save Properties"));

        load = new PropertiesLoad(this);
        load.getButton().setTooltip(new Tooltip("Load Properties"));

        saveFile = new FileSave(this);
        saveFile.getButton().setTooltip(new Tooltip("Save File"));

        loadFile = new FileLoad(this);
        loadFile.getButton().setTooltip(new Tooltip("Load File"));

        moveTurtle = new MoveTurtle(this);
        moveTurtle.getButton().setTooltip(new Tooltip("Move Turtle"));

        undo = new Undo(this);
        undo.getButton().setTooltip(new Tooltip("Undo"));

        redo = new Redo(this);
        redo.getButton().setTooltip(new Tooltip("Redo"));

        run = new Run(this);
        run.getButton().setTooltip(new Tooltip("Run"));

        var leftButtons = new HBox(openHelp.getButton(), switchLanguages.getButton(), saveFile.getButton(),
                loadFile.getButton(), BackgroundColor, PenColor, penThickess.getButton(), penState.getButton(),
                setTurtleImage.getButton(), save.getButton(), load.getButton());
        leftButtons.getStyleClass().add("button-container");

        var padding = new Region();

        var rightButtons = new HBox(moveTurtle.getButton(), undo.getButton(), redo.getButton(), run.getButton());
        rightButtons.getStyleClass().add("button-container");

        buttonHandler.setHgrow(padding, Priority.ALWAYS);
        buttonHandler.getChildren().addAll(leftButtons, padding, rightButtons);
        return buttonHandler;
    }

    public BorderPane getContainer() {
        return myContainer;
    }

    public void run() {
        editor.run();
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
                for (Turtle turtle: backendController.getImmutableTurtles()){
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
        turtles = new LinkedList<>(backendController.getImmutableTurtles());
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

    public void setBackgroundColor(Color color) {
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

    public void consoleShowCommandOutput(String commandOutput){
        console.showCommandOutput(commandOutput);
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
        turtles = new LinkedList<>(backendController.getImmutableTurtles());
        int counter = 0;
        List<Integer> ids = new ArrayList<>();
        List<Double> xPositions = new ArrayList<>();
        List<Double> yPositions = new ArrayList<>();
        List<Color> penColors = new ArrayList<>();
        List<Double> angles = new ArrayList<>();
        List<Boolean> penUp = new ArrayList<>();
        List<Integer> penSize = new ArrayList<>();
        for (Turtle turtle: turtles) {
            ImmutablePen pen = turtle.getMyPen();
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

    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("data/scripts"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File potentialFile = fileChooser.showSaveDialog(myStage);

        if (potentialFile != null) {
            ObservableList<CharSequence> paragraph = editor.getText();
            Iterator<CharSequence> iter = paragraph.iterator();
            try {
                PrintWriter initialWriter = new PrintWriter(potentialFile);
                BufferedWriter bf = new BufferedWriter(initialWriter);
                while (iter.hasNext()) {
                    CharSequence seq = iter.next();
                    bf.append(seq);
                    bf.newLine();
                }
                bf.flush();
                bf.close();
            } catch (IOException e) {
                consoleShowError("Error occurred when writing text to file!");
            }
        }
    }

    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("data/scripts"));
        File potentialFile = fileChooser.showOpenDialog(myStage);
        loadEditor(potentialFile);
    }

    public void loadEditor(File file) {
        try
        {
            Scanner s = new Scanner(file);
            editor.readText(s);
        }
        catch (FileNotFoundException e)
        {
            consoleShowError("File " + file.getName() + ".txt does not exist");
        }
        catch (NullPointerException e)
        {
            consoleShowError("Did not select a File");
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
     *
     * @param clazz
     */
    public void close(Class<?> clazz) {
        String className = clazz.getSimpleName();
        moduleList.remove(className);

        closeModule(myModuleContainer.getString(className), myModulePosition.getString(className));

        if (clazz.equals(console.getClass())) {
            myStage.setMaxHeight(stageReducedHeight);
        }
        else if ((clazz.equals(palettes.getClass()) && (! moduleList.contains("CurrentState")))
                || (clazz.equals(currentState.getClass()) && (! moduleList.contains("Palettes")))) {
            myContainer.setLeft(null);
            buttonHandler.setMinWidth(stageReducedWidth);
            buttonHandler.setMaxWidth(stageReducedWidth);
            console.getContent().setMinWidth(stageReducedWidth);
            console.getContent().setMaxWidth(stageReducedWidth);
            console.getToolbarPane().setMaxWidth(stageReducedWidth);
            if (myStage.getWidth() != stageReducedWidth) {
                myStage.setMaxWidth(stageReducedWidth);
            }
        }
        else if ((!moduleList.contains("Editor") && !moduleList.contains("AvailableVars") && !moduleList.contains("UserCommands"))) {
            myContainer.setRight(null);
            buttonHandler.setMinWidth(stageReducedWidth);
            buttonHandler.setMaxWidth(stageReducedWidth);
            console.getContent().setMinWidth(stageReducedWidth);
            console.getContent().setMaxWidth(stageReducedWidth);
            if (myStage.getWidth() != stageReducedWidth) {
                myStage.setMaxWidth(stageReducedWidth);
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
                    consoleShowError("Error Occurred when Removing Module");
                }
                break;
            case "leftBorderPane":
                try {
                    Method m = leftBorderPane.getClass().getMethod(modulePosition, Node.class);
                    m.invoke(leftBorderPane, (Object) null);
                } catch (Exception e) {
                    consoleShowError("Error Occurred when Removing Module");
                }
                break;
            case "rightBorderPane":
                try {
                    Method m = rightBorderPane.getClass().getMethod(modulePosition, Node.class);
                    m.invoke(rightBorderPane, (Object) null);
                } catch (Exception e) {
                    consoleShowError("Error Occurred when Removing Module");
                }
                break;
        }
    }

    public void showHelp(String helpPath) {
        Group helpGroup = new Group();

        Rectangle dialogBox = new Rectangle(0, 0, rectangleWidth, rectangleWidth);
        dialogBox.setEffect(new DropShadow(dropShadowPosition, 0, 0, Color.web("#333333")));
        dialogBox.setArcWidth(rectangleArc);
        dialogBox.setArcHeight(rectangleArc);
        dialogBox.setFill(Color.WHITE);

        TextArea help = new TextArea();
        help.setEditable(false);
        help.setLayoutY(helpLayoutY);
        help.setMaxWidth(rectangleWidth);
        help.setPrefHeight(helpPrefHeight);

        double originY = myStage.getScene().getHeight()/2 - dialogBox.getLayoutBounds().getHeight()/2 - positionToCenter;
        double originX = myStage.getScene().getWidth()/2 - dialogBox.getLayoutBounds().getWidth()/2;

        ButtonControl close = new CloseHelp(this, helpGroup);
        close.getButton().setLayoutX(dialogBox.getWidth() - positionToArrangeLeft);
        close.getButton().setLayoutY(closeButtonLayoutY);
        close.getButton().setCursor(Cursor.HAND);
        close.getButton().setTooltip(new Tooltip("Close Help"));

        Scanner s = new Scanner(this.getClass().getResourceAsStream(helpPath));
        while (s.hasNextLine()) {
            help.appendText(s.nextLine() + "\n");
        }

        helpGroup.getChildren().addAll(dialogBox, close.getButton(), help);

        helpGroup.setLayoutY(originY);
        helpGroup.setLayoutX(originX);

        myContainer.getChildren().add(helpGroup);
    }

    public void closeHelp(Group group) {
        myContainer.getChildren().remove(group);
    }

    public void setPenThickness(int value) {
        turtles = backendController.getMyTurtles();
        for (Turtle turtle: turtles) {
            turtle.setPenSize(turtle.getMyPen().getPenSize() + value);
        }
    }

    public void setPenState() {
        turtles = backendController.getMyTurtles();
        for (Turtle turtle: turtles) {
            turtle.setPenUp(!turtle.getMyPen().getPenUp());
        }
    }

    public void setPenColor(Color color) {
        turtles = backendController.getMyTurtles();
        for (Turtle turtle: turtles) {
            turtle.setPenColor(color);
        }
    }

    public void save() {
        Group saveGroup = new Group();

        Rectangle dialogBox = new Rectangle(0, 0, rectangleWidth, rectangleHeight);
        dialogBox.setEffect(new DropShadow(dropShadowPosition, 0, 0, Color.web("#333333")));
        dialogBox.setArcWidth(rectangleArc);
        dialogBox.setArcHeight(rectangleArc);
        dialogBox.setFill(Color.WHITE);

        double originY = myStage.getScene().getHeight()/2 - dialogBox.getLayoutBounds().getHeight()/2 - positionToCenter;
        double originX = myStage.getScene().getWidth()/2 - dialogBox.getLayoutBounds().getWidth()/2;

        backgroundColor = new TextField();
        backgroundColor.setPromptText("Enter background color (e.g. blue)");
        backgroundColor.setLayoutX(textFieldLayoutX);
        backgroundColor.setLayoutY(textFieldLayoutY);
        backgroundColor.setPrefWidth(textFieldWidth);

        penColor = new TextField();
        penColor.setPromptText("Enter pen color (e.g. black)");
        penColor.setLayoutX(textFieldLayoutX);
        penColor.setLayoutY(textFieldLayoutY + textFieldAdjustedY);
        penColor.setPrefWidth(textFieldWidth);

        numTurtles = new TextField();
        numTurtles.setPromptText("Enter number of turtles (e.g. 2)");
        numTurtles.setLayoutX(textFieldLayoutX);
        numTurtles.setLayoutY(textFieldLayoutY + textFieldAdjustedY * 2);
        numTurtles.setPrefWidth(textFieldWidth);

        language = new TextField();
        language.setPromptText("Enter language (e.g. English)");
        language.setLayoutX(textFieldLayoutX);
        language.setLayoutY(textFieldLayoutY + textFieldAdjustedY * 3);
        language.setPrefWidth(textFieldWidth);

        fileName = new TextField();
        fileName.setPromptText("Enter file name (e.g. test.txt)");
        fileName.setLayoutX(textFieldLayoutX);
        fileName.setLayoutY(textFieldLayoutY + textFieldAdjustedY * 4);
        fileName.setPrefWidth(textFieldWidth);

        ButtonControl close = new CloseHelp(this, saveGroup);
        close.getButton().setLayoutX(dialogBox.getWidth() - positionToArrangeLeft);
        close.getButton().setLayoutY(closeButtonLayoutY);
        close.getButton().setTooltip(new Tooltip("Close Save Preferences"));

        ButtonControl savePreferences = new Save(this);
        savePreferences.getButton().setLayoutX(dialogBox.getWidth()/2 - positionToCenter);
        savePreferences.getButton().setLayoutY(saveButtonLayoutY);
        savePreferences.getButton().setTooltip(new Tooltip("Save Preferences"));

        saveGroup.getChildren().addAll(dialogBox, backgroundColor, penColor, numTurtles, language, fileName, close.getButton(), savePreferences.getButton());

        saveGroup.setLayoutY(originY);
        saveGroup.setLayoutX(originX);

        myContainer.getChildren().add(saveGroup);
    }

    public void savePreferencesFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("data/preferences"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File potentialFile = fileChooser.showSaveDialog(myStage);

        if (potentialFile != null) {
            ObservableList<CharSequence> paragraph = editor.getText();
            Iterator<CharSequence> iter = paragraph.iterator();
            try {
                PrintWriter initialWriter = new PrintWriter(potentialFile);
                BufferedWriter bf = new BufferedWriter(initialWriter);
                saveBuffer("backgroundColor", bf);
                saveBuffer(backgroundColor.getText(), bf);
                saveBuffer("penColor", bf);
                saveBuffer(penColor.getText(), bf);
                saveBuffer("numTurtles", bf);
                saveBuffer(numTurtles.getText(), bf);
                saveBuffer("language", bf);
                saveBuffer(language.getText(), bf);
                saveBuffer("fileName", bf);
                saveBuffer(fileName.getText(), bf);
                bf.flush();
                bf.close();

            } catch (Exception e) {
                consoleShowError("Error occurred when writing text to file!");
            }
        }
    }

    private void saveBuffer(String content, BufferedWriter bf) {
        try {
            bf.append(content);
            bf.newLine();
        } catch (Exception e) {
            consoleShowError("Error occurred when saving preferences");
        }
    }

    public void load() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("data/preferences"));
        File potentialFile = fileChooser.showOpenDialog(myStage);
        int counter = 0;
        try
        {
            Scanner s = new Scanner(potentialFile);
            while(s.hasNextLine()) {
                String bundleReference = s.nextLine();
                String methodName = myPreferences.getString(bundleReference);
                String parameter = s.nextLine();
                loadPropertyMethod(counter, methodName, parameter);
                counter++;
            }
        }
        catch (FileNotFoundException e)
        {
            consoleShowError("File " + potentialFile.getName() + ".txt does not exist");
        }
        catch (NullPointerException e)
        {
            consoleShowError("Did not select a File");
        }
    }

    private void loadPropertyMethod(int counter, String methodName, String parameter) {
        switch(counter) {
            case 0:
                try {
                    Method method = this.getClass().getDeclaredMethod(methodName, Color.class);
                    method.invoke(this, Color.valueOf(parameter));
                } catch (Exception e) {
                    consoleShowError("Error occurred when setting background color");
                }
                break;
            case 1:
                try {
                    Method method = this.getClass().getDeclaredMethod(methodName, Color.class);
                    method.invoke(this, Color.valueOf(parameter));
                } catch (Exception e) {
                    consoleShowError("Error occurred when setting pen color");
                }
                break;
            case 2:
                try {
                    Method method = this.getClass().getDeclaredMethod(methodName, String.class);
                    method.invoke(this, "tell " + parameter);
                } catch (Exception e) {
                    consoleShowError("Error occurred when setting number of turtles");
                }
                break;
            case 3:
                try {
                    Method method = this.getClass().getDeclaredMethod(methodName, String.class);
                    method.invoke(this, parameter);
                } catch (Exception e) {
                    consoleShowError("Error occurred when setting language");
                }
                break;
            case 4:
                try {
                    Method method = this.getClass().getDeclaredMethod(methodName, File.class);
                    method.invoke(this, new File("data/scripts/" + parameter));
                } catch (Exception e) {
                    consoleShowError("Error occurred when loading file");
                }
                break;
        }
    }
}
