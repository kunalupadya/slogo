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
 *
 * @author David Liu
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

    public Console(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        myResourceBundles = getMyResourceBundles();
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
        System.out.println(container.getHeight());
        container.prefWidthProperty().bind(content.widthProperty());
        content.getChildren().add(container);
        commandHistory = new ArrayList<>();
        commandPosition = -1;
        consoleInfo = new TextArea();
        consoleInfo.setEditable(false);
        consoleInfo.prefWidthProperty().bind(container.widthProperty());
        consoleInfo.setFont(courier);
        consoleInfo.setPromptText(myResourceBundles.getString("ConsoleInfoPromptText"));
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
                commandHistory.add(0, parameterValue);
                commandPosition = -1;
                consoleInput.clear();
                context.sendCommandString(parameterValue);
                consoleInfo.getStyleClass().removeAll(myResourceBundles.getString("ConsoleStyleRed"));
                consoleInfo.getStyleClass().add(myResourceBundles.getString("ConsoleStyleBlack"));
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

    public void showError(String errorString) {
        if (! consoleInfo.getText().equals("")) {
            consoleInfo.appendText("\n" + errorString);
        }
        else {
            consoleInfo.appendText(errorString);
        }
        consoleInfo.getStyleClass().removeAll(myResourceBundles.getString("ConsoleStyleBlack"));
        consoleInfo.getStyleClass().add(myResourceBundles.getString("ConsoleStyleRed"));
    }

    public void addToConsole(String commandString) {
        consoleInput.clear();
        consoleInput.appendText(commandString);
    }
}
