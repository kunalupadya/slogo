package GUI.Modules;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import java.util.List;
import java.util.ResourceBundle;

import GUI.FrontendController;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

/**
 * @author David Liu
 */

/**
 * CurrentState Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize CurrentState with width 200 and height 250, with a moduleName of "CurrentState" and a new FrontendController
 * object
 */
public class CurrentState extends ListModule {
    private ResourceBundle myResourceBundles;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

    /**
     * Constructor of CurrentState, sets up the two Panes that contains all the necessary content and labels
     * Also sets up the list associated with the view that will be displayed
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public CurrentState(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        list = getList();
        listCollection = getListCollection();
    }

    @Override
    protected void setPlaceholder() {
        myResourceBundles = getMyResourceBundles();
        listDisplay = getListDisplay();
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("TurtleAndPens")));
    }

    /**
     * Writes each turtle's state and it's pen's state together as one string in order to display as a list view
     * @param ids Turtles ID
     * @param xPositions Turtles xPosition
     * @param yPositions Turtles yPosition
     * @param angles Turtles heading
     * @param penColors Turtles pen's color
     * @param penUp Turtles pen's up/down state
     * @param penSize Turtle pen's size
     */
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
                    yPositions.get(i).toString() + " " + angles.get(i).toString() + " " + myResourceBundles.getString("Pen") + penColors.get(i).toString()
                    + " " + penDirection + " " + penSize.get(i).toString();
            list.add(turtleAndPen);
            listCollection.add(turtleAndPen);
        }
    }
}
