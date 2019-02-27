package GUI.Modules;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.security.Key;

/**
 * TODO: work on testing how a console works
 */

public class Console extends Module  {
    private VBox container;
    private TextArea consoleInfo;
    private TextField consoleInput;
    private Font courier;
    //private

    public Console(int width, int height) {
        super(width, height);
        courier = new Font("Courier", 12);
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.setPrefWidth(moduleWidth);
        container.setPrefHeight(moduleHeight);
        content.setContent(container);
        consoleInfo = new TextArea();
        consoleInfo.setEditable(false);
        consoleInfo.setFont(courier);
        consoleInput = new TextField();
        consoleInput.setFont(courier);
        consoleInput.setOnKeyReleased(event -> handleKeyInput(event.getCode()));
        container.getChildren().addAll(consoleInfo, consoleInput);
    }

    private void handleKeyInput(KeyCode code) {
        if (code == KeyCode.ENTER) {
            String parameterValue = consoleInput.getText();
            //send consoleinput to the backend
            //String placeholderText = consoleInfo.getText();
            //placeholderText = placeholderText + "\n" + parameterValue;
            consoleInfo.appendText("\n" + parameterValue);
            consoleInput.clear();
        }
        if (code == KeyCode.UP) {
            
        }
        if (code == KeyCode.DOWN) {

        }
    }
}
