package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author David Liu
 */

/**
 * Console Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize Console with width 200 and height 250, with a moduleName of "Console" and a new FrontendController
 * object
 */
public class Console extends Module  {
    private TextArea consoleInfo;
    private TextField consoleInput;
    private List<String> commandHistory;
    private int commandPosition;
    private Font courier;
    private ResourceBundle myResourceBundles;
    private VBox container;
    private Pane content;
    private int moduleHeight;
    private FrontendController context;
    private double toolbarHeight;

    /**
     * Constructor of Console, sets up the two Panes that contains all the necessary content and labels
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public Console(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        myResourceBundles = getMyResourceBundles();
        toolbarHeight = getToolbarHeight();
        courier = new Font(myResourceBundles.getString("Font"), 12);
        content = getPane();
        moduleHeight = getModuleHeight();
        context = getContext();
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.setPrefHeight(moduleHeight - toolbarHeight + 2);
        container.prefWidthProperty().bind(content.widthProperty());
        content.getChildren().add(container);
        commandHistory = new ArrayList<>();
        commandPosition = -1;
        consoleInfo = new TextArea();
        consoleInfo.setEditable(false);
        consoleInfo.prefWidthProperty().bind(container.widthProperty());
        consoleInfo.setFont(courier);
        consoleInfo.setPromptText(myResourceBundles.getString("ConsoleInfoPromptText"));
        consoleInfo.getStyleClass().add(myResourceBundles.getString("ConsoleStyleBlack"));
        consoleInput = new TextField();
        consoleInput.setFont(courier);
        consoleInput.setPromptText(myResourceBundles.getString("ConsoleInputPromptText"));
        consoleInput.prefWidthProperty().bind(container.widthProperty());
        consoleInput.setOnKeyReleased(event -> handleKeyInput(event.getCode()));
        container.getChildren().addAll(consoleInfo, consoleInput);
    }

    private void handleKeyInput(KeyCode code) {
        if (code == KeyCode.ENTER) {
            String parameterValue = consoleInput.getText();
            if (!parameterValue.trim().isEmpty()) {
                if (consoleInfo.getText().trim().isEmpty()) {
                    consoleInfo.appendText(parameterValue);
                }
                else {
                    consoleInfo.appendText("\n" + parameterValue);
                }
                consoleInfo.getStyleClass().set(consoleInfo.getStyleClass().size() - 1,
                        myResourceBundles.getString("ConsoleStyleBlack"));
                commandHistory.add(0, parameterValue);
                commandPosition = -1;
                consoleInput.clear();
                context.sendCommandString(parameterValue);
            }
        }
        if (code == KeyCode.UP) {
            if (!commandHistory.isEmpty() && !(commandPosition >= commandHistory.size() - 1)) {
                consoleInput.clear();
                commandPosition = commandPosition + 1;
                consoleInput.appendText(commandHistory.get(commandPosition));
            }
        }
        if (code == KeyCode.DOWN) {
            if (!(commandPosition <= 0)) {
                consoleInput.clear();
                commandPosition = commandPosition - 1;
                consoleInput.appendText(commandHistory.get(commandPosition));
            }
            else if (commandPosition == 0) {
                consoleInput.clear();
            }
        }
    }

    /**
     * Appends error message from backend to the console text area
     * @param errorString Error message
     */
    public void showError(String errorString) {
        if (!consoleInfo.getText().equals("")) {
            consoleInfo.appendText("\n" + errorString);
        }
        else {
            consoleInfo.appendText(errorString);
        }
        consoleInfo.getStyleClass().set(consoleInfo.getStyleClass().size() - 1,
                myResourceBundles.getString("ConsoleStyleRed"));
    }

    /**
     * Appends output of a command from backend to the console text area
     * @param commandOutput output of a command if needed
     */
    public void showCommandOutput(String commandOutput){
        if (!consoleInfo.getText().equals("")) {
            consoleInfo.appendText("\n" + commandOutput);
        }
        else {
            consoleInfo.appendText(commandOutput);
        }
        consoleInfo.getStyleClass().set(consoleInfo.getStyleClass().size() - 1,
                myResourceBundles.getString("ConsoleStyleBlue"));
    }

    /**
     * Appends string of command from backend to the console text area
     * @param commandString command String
     */
    public void addToConsole(String commandString) {
        consoleInput.clear();
        consoleInput.appendText(commandString);
    }
}
