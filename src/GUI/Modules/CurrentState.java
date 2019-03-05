package GUI.Modules;

import GUI.WindowLayout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class CurrentState extends Module {
    private VBox container;
    private List<String> turtleAndPens;
    private ListView<String> turtleAndPensDisplay;
    private ObservableList<String> turtleAndPensCollection;

    public CurrentState(int width, int height, WindowLayout myWindowLayout) {
        super(width, height, "Current States", myWindowLayout);
        turtleAndPens = new ArrayList<>();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        content.setContent(container);
        container.prefHeightProperty().bind(content.heightProperty());
        if (turtleAndPens != null) {
            turtleAndPensCollection = FXCollections.<String>observableArrayList(turtleAndPens);
            turtleAndPensDisplay = new ListView<>(turtleAndPensCollection);
            turtleAndPensDisplay.setOrientation(Orientation.VERTICAL);
            turtleAndPensDisplay.prefHeightProperty().bind(container.heightProperty());
            turtleAndPensDisplay.setPrefWidth(moduleWidth);
            turtleAndPensDisplay.setPlaceholder(new Label("User Commands"));
        }
        container.getChildren().add(turtleAndPensDisplay);
    }

    public void getTurtleAndPens() {

    }
}
