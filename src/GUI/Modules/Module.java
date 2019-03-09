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
    private ResourceBundle myResourceBundles;
    private Pane content;
    private final VBox module;
    private Pane toolbarPane;
    private int moduleWidth;
    private int moduleHeight;
    private FrontendController context;
    private ButtonControl close;

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
        title.setLayoutY(13);
        title.setLayoutX(25);

        close = new Close(this, this.getClass());
        close.getButton().setLayoutX(0);
        close.getButton().setLayoutY(-2);

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

    public Pane getToolbarPane() { return toolbarPane; }

    public ButtonControl getClose() { return close; }
}
