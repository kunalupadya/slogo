package GUI.Modules;

import javafx.scene.control.Label;
import java.util.List;
import GUI.FrontendController;
import javafx.scene.paint.Color;

public class CurrentState extends ListModule {

    public CurrentState(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Current States", myFrontendController);
    }

    @Override
    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("TurtleAndPens")));
    }

    public void getTurtleAndPens(List<Integer> ids, List<Double> xPositions, List<Double> yPositions, List<Double> angles,
                                 List<Color> penColors, List<Boolean> penUp, List<Integer> penSize) {
        listCollection.clear();
        list.clear();
        String penDirection;
        for (int i = 0; i < ids.size(); i++) {
            if (penUp.get(i)) {
                penDirection = myResourceBundles.getString("PenUp");
            }
            else {
                penDirection = myResourceBundles.getString("PenDown");
            }
            String turtleAndPen = myResourceBundles.getString("Turtle") + ids.get(i).toString() + " " + xPositions.get(i).toString() + " " +
                    yPositions.get(i).toString() + " " + angles.get(i).toString() + myResourceBundles.getString("Pen") + penColors.get(i).toString()
                    + " " + penDirection + " " + penSize.get(i).toString();
            list.add(turtleAndPen);
            listCollection.add(turtleAndPen);
        }
    }
}
