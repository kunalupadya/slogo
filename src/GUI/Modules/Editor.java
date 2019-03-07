package GUI.Modules;

import GUI.FrontendController;
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

    public Editor(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Editor", myFrontendController);
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
//        content.setContent(container);
        container.prefHeightProperty().bind(content.heightProperty());
        editor = new TextArea();
        editor.setWrapText(true);
        editor.setFont(new Font("Courier", 12));
        editor.prefHeightProperty().bind(container.heightProperty());
        editor.setPrefWidth(moduleWidth);
        editor.setPromptText("Editor");
        container.getChildren().add(editor);
        content.getChildren().add(container);
    }

    public void run() {
        //do a better job of "debugging" the editor text
        editorText = editor.getText();
        if (! editorText.equals("")) {
            editorText = editorText.replace("\n", " ");
        }
        context.sendCommandString(editorText);
        editor.clear();
    }
}
