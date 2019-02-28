package GUI.Modules;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
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

    public Editor(int width, int height) {
        super(width, height);
        setContent();
        content.setMaxSize(width*2, height*2);
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
    protected void setLayout() {
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
        //send to the parser
    }
}
