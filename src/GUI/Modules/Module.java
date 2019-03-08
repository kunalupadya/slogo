package GUI.Modules;

import GUI.Controls.Close;
import GUI.Controls.ButtonControl;
import GUI.FrontendController;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import java.util.ResourceBundle;

/**
 * Superclass to serve as template for the separate modules (Abstract?)
 *
 * @author Januario Carreiro & David Liu
 */
public abstract class Module {
    public ResourceBundle myResourceBundles;
    public VBox container;
    public Pane content;
    public final VBox module;
    Pane toolbarPane;
    public int moduleWidth;
    public int moduleHeight;
    public FrontendController context;
    ButtonControl close;

    final double toolbarHeight = 20.0;

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
        title.setLayoutY(10);
        title.setLayoutX(5);

        close = new Close(this, this.getClass());
        close.getButton().setLayoutX(moduleWidth - 25);
        close.getButton().setLayoutY(-6);

        toolbarPane.getChildren().addAll(title, close.getButton());
    }

    protected abstract void setContent();

    public VBox getContent() {
        return module;
    }

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

    protected Pane getToolbarPane() { return toolbarPane; }

    public ButtonControl getClose() { return close; }
}
