package GUI.Modules;

import GUI.Controls.Close;
import GUI.Controls.Control;
import GUI.FrontendController;
import Main.TextMaker;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Superclass to serve as template for the separate modules (Abstract?)
 *
 * @author Januario Carreiro & David Liu
 */
public abstract class Module {
    public Pane content;
    public final VBox module;
    Pane toolbarPane;
    public int moduleWidth;
    public int moduleHeight;
    public FrontendController context;
    Control close;

    final double toolbarHeight = 20.0;

    public Module(int width, int height, String moduleName, FrontendController context) {
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

        Text title = TextMaker.makeText(moduleName, new Font("Courier", 12));
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

}
