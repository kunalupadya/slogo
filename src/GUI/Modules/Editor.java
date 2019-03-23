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
 * @author David Liu
 */

/**
 * Editor Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize Editor with width 200 and height 250, with a moduleName of "Editor" and a new FrontendController
 * object
 */
public class Editor extends Module {
    private VBox container;
    private Pane content;
    private TextArea editor;
    private String editorText;
    private int moduleWidth;
    private ResourceBundle myResourceBundles;
    private FrontendController context;

    /**
     * Constructor of Editor, sets up the two Panes that contains all the necessary content and labels
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
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

    /**
     * Method that gets called from the run Control which sends the current text in the editor to the
     * FrontEndController which will get sent to the back-end
     */
    public void run() {
        editorText = editor.getText();
        if (!editorText.trim().isEmpty()) {
            context.sendCommandString(editorText);
        }
    }

    /**
     * Sends the text in an observablelist format
     * @return ObservableList of the text
     */
    public ObservableList<CharSequence> getText() {
        return editor.getParagraphs();
    }

    /**
     * Reads the file inputted using a scanner and appends it to the editor
     * @param s Scanner that reads the file inputted in
     */
    public void readText(Scanner s) {
        editor.clear();
        while (s.hasNextLine()) {
            editor.appendText(s.nextLine() + "\n");
        }
    }
}
