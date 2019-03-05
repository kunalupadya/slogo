package GUI.Modules;

import GUI.Controls.Close;
import GUI.Controls.Control;
import GUI.FrontendController;
import Main.TextMaker;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Superclass to serve as template for the separate modules (Abstract?)
 *
 * @author Januario Carreiro & David Liu
 */
public abstract class Module {
    public final ScrollPane content;
    public final VBox vbox;
    public int moduleWidth;
    public int moduleHeight;
    public FrontendController context;

    public Module(int width, int height, String moduleName, FrontendController context) {
        moduleWidth = width;
        moduleHeight = height;
        this.vbox = new VBox();
        vbox.setId("module");
        this.content = new ScrollPane();
        content.setMinSize(width, height);
        this.context = context;
        setLayout();
        addToolbar(moduleName);
    }

    private void setLayout() {
        content.setPrefViewportWidth(moduleWidth);
        content.setPrefViewportHeight(moduleHeight);
        content.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        content.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    protected void addToolbar(String moduleName) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setId("toolbar");

        Text title = TextMaker.makeText(moduleName, new Font("Courier", 12), 0, 0);

        var padding = new Region();

        Control close = new Close(this);

        hbox.setHgrow(padding, Priority.ALWAYS);
        hbox.getChildren().addAll(title, padding, close.getButton());
        vbox.getChildren().addAll(hbox, content);
    }

    protected abstract void setContent();

    protected void setStyle(){

    }

    public VBox getContent() {
        return vbox;
    }

    public VBox getVBox() {return vbox;}

    public void close() {}

}
