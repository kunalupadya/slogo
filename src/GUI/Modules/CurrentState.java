package GUI.Modules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import GUI.FrontendController;
import javafx.scene.paint.Color;

public class CurrentState extends ListModule {
    private VBox container;

    public CurrentState(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Current States", myFrontendController);
    }

    @Override
    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label("Turtles and Pens"));
    }

    public void getTurtleAndPens(List<Integer> ids, List<Double> xPositions, List<Double> yPositions, List<Double> angles,
                                 List<Color> penColors, List<Boolean> penUp, List<Integer> penSize) {
        listCollection.clear();
        list.clear();
        String penDirection;
        for (int i = 0; i < ids.size(); i++) {
            if (penUp.get(i)) {
                penDirection = "Up";
            }
            else {
                penDirection = "Down";
            }
            String turtleAndPen = "Turtle: " + ids.get(i).toString() + " " + xPositions.get(i).toString() + " " +
                    yPositions.get(i).toString() + " " + angles.get(i).toString() + " Pen: " + penColors.get(i).toString()
                    + " " + penDirection + " " + penSize.get(i).toString();
            list.add(turtleAndPen);
            listCollection.add(turtleAndPen);
        }
    }
}
