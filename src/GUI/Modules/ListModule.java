package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Liu
 */

public abstract class ListModule extends Module {
    private VBox container;
    private Pane content;
    private int moduleWidth;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

    public ListModule(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        list = new ArrayList<>();
        content = getPane();
        moduleWidth = getModuleWidth();
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.prefHeightProperty().bind(content.heightProperty());
        if (list != null) {
            listCollection = FXCollections.observableArrayList(list);
            listDisplay = new ListView<>(listCollection);
            listDisplay.setOrientation(Orientation.VERTICAL);
            listDisplay.prefHeightProperty().bind(container.heightProperty());
            listDisplay.setPrefWidth(moduleWidth);
            setPlaceholder();
        }
        container.getChildren().add(listDisplay);
        content.getChildren().add(container);
    }

    protected abstract void setPlaceholder();

    public List<String> getList() {
        return list;
    }

    public ListView<String> getListDisplay() {
        return listDisplay;
    }

    public ObservableList<String> getListCollection() {
        return listCollection;
    }
}
