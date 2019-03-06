package GUI.Modules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import GUI.FrontendController;
import javafx.scene.paint.Color;

public class CurrentState extends Module {
    private VBox container;
    private List<String> turtleAndPens;
    private ListView<String> turtleAndPensDisplay;
    private ObservableList<String> turtleAndPensCollection;

    public CurrentState(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Current States", myFrontendController);
        turtleAndPens = new ArrayList<>();
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
        container.prefHeightProperty().bind(content.heightProperty());
        if (turtleAndPens != null) {
            turtleAndPensCollection = FXCollections.<String>observableArrayList(turtleAndPens);
            turtleAndPensDisplay = new ListView<>(turtleAndPensCollection);
            turtleAndPensDisplay.setOrientation(Orientation.VERTICAL);
            turtleAndPensDisplay.prefHeightProperty().bind(container.heightProperty());
            turtleAndPensDisplay.setPrefWidth(moduleWidth);
            turtleAndPensDisplay.setPlaceholder(new Label("Turtles and Pens"));
        }
        container.getChildren().add(turtleAndPensDisplay);
        content.getChildren().add(container);
    }

    public void getTurtleAndPens(List<Integer> ids, List<Double> xPositions, List<Double> yPositions, List<Double> angles,
                                 List<Optional<Color>> penColors, List<Boolean> penUp, List<Integer> penSize) {
        turtleAndPens.clear();
        turtleAndPensCollection.clear();
        for (int i = 0; i < ids.size(); i++) {
            String penDirection;
            if (penUp.get(i)) {
                penDirection = "Up";
            }
            else {
                penDirection = "Down";
            }
            String turtlePen = "Turtle: " + ids.get(i).toString() + " " + xPositions.get(i).toString() + " "
                    + yPositions.get(i).toString() + " " + angles.get(i).toString() + " Pen: " + penColors.get(i).toString() + " " +
                    penDirection + " " + penSize.get(i).toString();
            turtleAndPens.add(turtlePen);
            turtleAndPensCollection.add(turtlePen);
        }
    }
}
