package GUI.Modules;

import Main.BackendController;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: send consoleinput to the backend
 * TODO: get prompt text from a resource file, not hardcoded
 */

public class Console extends Module  {
    private VBox container;
    private TextArea consoleInfo;
    private TextField consoleInput;
    private List<String> commandHistory;
    private int commandPosition;
    private Font courier;
    private BackendController backendController;

    public Console(int width, int height) {
        super(width, height);
        courier = new Font("Courier", 12);
        setContent();
    }

    public void setBackendController(BackendController backendController) {
        this.backendController = backendController;
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.setPrefHeight(moduleHeight);
        System.out.println(container.getHeight());
        container.prefWidthProperty().bind(content.widthProperty());
        content.setContent(container);
        commandHistory = new ArrayList<>();
        commandPosition = -1;
        consoleInfo = new TextArea();
        consoleInfo.setEditable(false);
        consoleInfo.prefWidthProperty().bind(container.widthProperty());
        consoleInfo.setFont(courier);
        consoleInfo.setPromptText("Previous commands");
        consoleInput = new TextField();
        consoleInput.setFont(courier);
        consoleInput.setPromptText("Enter command: ");
        consoleInput.prefWidthProperty().bind(container.widthProperty());
        consoleInput.setOnKeyReleased(event -> handleKeyInput(event.getCode()));
//        container.setVgrow(consoleInput, Priority.ALWAYS);
        container.getChildren().addAll(consoleInfo, consoleInput);
    }

    private void handleKeyInput(KeyCode code) {
        if (code == KeyCode.ENTER) {
            String parameterValue = consoleInput.getText();
            if (commandHistory.isEmpty()) {
                consoleInfo.appendText(parameterValue);
            }
            else {
                consoleInfo.appendText("\n" + parameterValue);
            }
            commandHistory.add(0, parameterValue);
            commandPosition = -1;
            //send parametervalue to parsecommand
            System.out.println(backendController);
            backendController.parseAndRun(parameterValue);
            consoleInput.clear();
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

    //show method in console class so that console can show error messages on the screen
    private void showError() {
        //receive error message from handleerror class?
    }
}
