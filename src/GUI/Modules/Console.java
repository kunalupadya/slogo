package GUI.Modules;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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

    public Console(int width, int height) {
        super(width, height);
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.setPrefWidth(moduleWidth);
        container.setPrefHeight(moduleHeight);
        content.setContent(container);
        commandHistory = new ArrayList<>();
        commandPosition = -1;
        consoleInfo = new TextArea();
        consoleInfo.setEditable(false);
        consoleInput = new TextField();
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
}
