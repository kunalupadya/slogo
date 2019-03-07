package GUI.Modules;

import GUI.Controls.Close;
import GUI.Controls.Control;
import GUI.FrontendController;
import Main.TextMaker;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
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
    private Control close;

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
        Text title = TextMaker.makeText(moduleName, new Font(myResourceBundles.getString("Font"), 12));
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

    public Pane getPane() {
        return content;
    }

    public int getModuleWidth() {
        return moduleWidth;
    }

    public ResourceBundle getMyResourceBundles() {
        return myResourceBundles;
    }

    public FrontendController getContext() {
        return context;
    }

    public int getModuleHeight() { return moduleHeight; }

    public Pane getToolbarPane() { return toolbarPane; }

    public Control getClose() { return close; }
}
