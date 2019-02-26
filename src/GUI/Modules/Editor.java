package GUI.Modules;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Editor extends Module {
    private VBox container;
    private TextArea editor;

    public Editor(int width, int height) {
        super(width, height);
        setContent();
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
        editor = new TextArea();
        editor.setWrapText(true);
    }

    public void run() {

    }
}
