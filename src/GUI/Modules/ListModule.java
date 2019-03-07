package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ListModule extends Module {
    public List<String> list;
    public ListView<String> listDisplay;
    public ObservableList<String> listCollection;

    public ListModule(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        list = new ArrayList<>();
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

    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label("List"));
    }
}
