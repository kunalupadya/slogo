package GUI.Modules;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: send consoleinput to the backend
 */

public class Console extends Module  {
    private VBox container;
    private TextArea consoleInfo;
    private TextField consoleInput;
    private List<String> commandHistory;
    private int commandPosition;
    private Font courier;

    public Console(int width, int height) {
        super(width, height);
        courier = new Font("Courier", 12);
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.setPrefHeight(moduleHeight);
        container.prefWidthProperty().bind(content.widthProperty());
        content.setContent(container);
        commandHistory = new ArrayList<>();
        commandPosition = -1;
        consoleInfo = new TextArea();
        consoleInfo.setEditable(false);
        consoleInfo.prefWidthProperty().bind(container.widthProperty());
        consoleInfo.setFont(courier);
        consoleInput = new TextField();
        consoleInput.setFont(courier);
        consoleInput.prefWidthProperty().bind(container.widthProperty());
        consoleInput.setOnKeyReleased(event -> handleKeyInput(event.getCode()));
        container.getChildren().addAll(consoleInfo, consoleInput);
    }

    private void handleKeyInput(KeyCode code) {
        if (code == KeyCode.ENTER) {
            String parameterValue = consoleInput.getText();
            commandHistory.add(0, parameterValue);
            commandPosition = -1;
            //send consoleinput to the backend
            consoleInfo.appendText("\n" + parameterValue);
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

    private void showError() {

    }
}
