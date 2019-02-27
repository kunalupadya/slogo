package GUI.Modules;

import javafx.scene.control.ScrollPane;

/**
 * Superclass to serve as template for the separate modules (Abstract?)
 *
 * @author Januario Carreiro & David Liu
 */
public abstract class Module {
    public final ScrollPane content;

    public final int moduleWidth;
    public final int moduleHeight;

    public Module(int width, int height) {
        moduleWidth = width;
        moduleHeight = height;
        this.content = new ScrollPane();
        setLayout();
    }

    protected void setLayout() {
        content.setPrefViewportWidth(moduleWidth);
        content.setPrefViewportHeight(moduleHeight);
        content.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        content.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    protected abstract void setContent();

    protected void setStyle(){

    }

    public ScrollPane getContent() {
        return content;
    }
}
