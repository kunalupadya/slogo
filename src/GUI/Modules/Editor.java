package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 */

public class Editor extends Module {
    private VBox container;
    private Pane content;
    private TextArea editor;
    private String editorText;
    private int moduleWidth;
    private ResourceBundle myResourceBundles;
    private FrontendController context;

    public Editor(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        content = getPane();
        myResourceBundles = getMyResourceBundles();
        moduleWidth = getModuleWidth();
        context = getContext();
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.prefHeightProperty().bind(content.heightProperty());
        editor = new TextArea();
        editor.setWrapText(true);
        editor.setFont(new Font(myResourceBundles.getString("Font"), 12));
        editor.prefHeightProperty().bind(container.heightProperty());
        editor.setPrefWidth(moduleWidth);
        editor.setPromptText(myResourceBundles.getString("Editor"));
        container.getChildren().add(editor);
        content.getChildren().add(container);
    }

    public void run() {
        editorText = editor.getText();
        if (!editorText.trim().isEmpty()) {
            editorText = editorText.replace("\n", " ");
            context.sendCommandString(editorText);
        }
        editor.clear();
    }

    public ObservableList<CharSequence> getText() {
        return editor.getParagraphs();
    }

    public void readText(Scanner s) {
        editor.clear();
        while (s.hasNextLine()) {
            editor.appendText(s.nextLine() + "\n");
        }
    }
}
