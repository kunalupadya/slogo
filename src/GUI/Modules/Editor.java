package GUI.Modules;

import GUI.WindowLayout;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * TODO: Have text read through a resource file, not hard coded
 * TODO: Don't have magic number for setmaxsize, adjust accordingly
 */

public class Editor extends Module {
    private VBox container;
    private TextArea editor;
    private String editorText;

    public Editor(int width, int height, WindowLayout myWindowLayout) {
        super(width, height, myWindowLayout);
        setContent();
//        editor.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
//            @Override
//            public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
//                if (moduleHeight != newValue.getHeight()) {
//                    moduleHeight = (int) newValue.getHeight();
//                    editor.setPrefHeight(editor.getLayoutBounds().getHeight() + 20);
//                    System.out.println(editor.getLayoutBounds().getHeight());
//                }
//            }
//        });
    }

    @Override
    protected void setStyle(){
    }

    @Override
    protected void setContent() {
        container = new VBox();
        content.setContent(container);
        container.prefHeightProperty().bind(content.heightProperty());
        editor = new TextArea();
        editor.setWrapText(true);
        editor.setFont(new Font("Courier", 12));
        editor.prefHeightProperty().bind(container.heightProperty());
        editor.setPrefWidth(moduleWidth);
        editor.setPromptText("Editor");
        container.getChildren().add(editor);
    }

    public void run() {
        //do a better job of "debugging" the editor text
        editorText = editor.getText();
        if (editorText != "") {
            editorText = editorText.replace("\n", " ");
        }
        context.sendCommandString(editorText);
        editor.clear();
    }
}
