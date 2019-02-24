package GUI.Modules;

import javafx.scene.control.ScrollPane;

/**
 * Superclass to serve as template for the separate modules (Abstract?)
 *
 * @author Januario Carreiro & David Liu
 */
public abstract class Module extends ScrollPane {
    private int moduleWidth;
    private int moduleHeight;

    public Module(int width, int height) {
        moduleWidth = width;
        moduleHeight = height;
        setLayout();
    }

    protected void setLayout() {
        setWidth(moduleWidth);
        setHeight(moduleHeight);
        setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
    }

    protected abstract void setContent();

    protected void setStyle(){
    }
}
