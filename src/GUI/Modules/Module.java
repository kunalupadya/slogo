package GUI.Modules;

import GUI.WindowLayout;
import javafx.scene.control.ScrollPane;

/**
 * Superclass to serve as template for the separate modules (Abstract?)
 *
 * @author Januario Carreiro & David Liu
 */
public abstract class Module {
    public final ScrollPane content;

    public int moduleWidth;
    public int moduleHeight;
    public WindowLayout context;

    public Module(int width, int height, WindowLayout context) {
        moduleWidth = width;
        moduleHeight = height;
        this.content = new ScrollPane();
        content.setMinSize(width, height);
        this.context = context;
        setLayout();
    }

    protected void setLayout() {
        content.setPrefViewportWidth(moduleWidth);
        content.setPrefViewportHeight(moduleHeight);
        content.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        content.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    protected abstract void setContent();

    protected void setStyle(){

    }

    public ScrollPane getContent() {
        return content;
    }
}
