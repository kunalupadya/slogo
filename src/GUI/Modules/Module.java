package GUI.Modules;

import GUI.Controls.Close;
import GUI.Controls.ButtonControl;
import GUI.FrontendController;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import java.util.ResourceBundle;

/**
 * @author David Liu & Januario Carreiro
 */

/**
 * Abstract Module Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize a Module with width 200 and height 250, with a moduleName of "Editor" and a new FrontendController
 * object
 */
public abstract class Module {
    private ResourceBundle myResourceBundles;
    private Pane content;
    private final VBox module;
    private Pane toolbarPane;
    private int moduleWidth;
    private int moduleHeight;
    private FrontendController context;
    private ButtonControl close;
    private final double toolbarHeight = 20.0;

    /**
     * Constructor of Module, sets up the two Panes that contains all the necessary content and labels
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param context FrontendController object
     */
    public Module(int width, int height, String moduleName, FrontendController context) {
        this.myResourceBundles = ResourceBundle.getBundle("/moduleProperties/ModuleLabel");
        this.module = new VBox();
        this.content = new Pane();
        this.moduleWidth = width;
        this.moduleHeight = height;
        this.context = context;
        module.setMinSize(moduleWidth, moduleHeight);
        module.setMaxSize(moduleWidth, moduleHeight);
        module.setId("module");
        addToolbar(moduleName);
        content.prefHeightProperty().bind(module.heightProperty());
        content.prefWidthProperty().bind(module.widthProperty());
        module.getChildren().addAll(toolbarPane, content);
    }

    protected void addToolbar(String moduleName) {
        this.toolbarPane = new Pane();
        toolbarPane.setPrefWidth(moduleWidth);
        toolbarPane.setMinHeight(toolbarHeight);
        toolbarPane.setId("toolbar");
        Text title = new Text(moduleName);
        title.setLayoutY(13);
        title.setLayoutX(25);

        close = new Close(this, this.getClass());
        close.getButton().setLayoutX(0);
        close.getButton().setLayoutY(-2);

        toolbarPane.getChildren().addAll(title, close.getButton());
    }

    protected abstract void setContent();

    /**
     * Gets both Panes which make up the module's content
     * @return VBox which houses both Panes
     */
    public VBox getContent() {
        return module;
    }

    /**
     * Calls the FrontendController method close for that particular class
     * @param clazz a specific Class
     */
    public void close(Class clazz) {context.close(clazz);}

    protected Pane getPane() {
        return content;
    }

    protected int getModuleWidth() {
        return moduleWidth;
    }

    protected ResourceBundle getMyResourceBundles() {
        return myResourceBundles;
    }

    protected FrontendController getContext() {
        return context;
    }

    protected int getModuleHeight() { return moduleHeight; }

    protected double getToolbarHeight() { return toolbarHeight; }

    /**
     * Gets the pane with the label only
     * @return the label pane
     */
    public Pane getToolbarPane() { return toolbarPane; }

    /**
     * Gets the close button located on the top right of each module (view)
     * @return the close button
     */
    public ButtonControl getClose() { return close; }
}
