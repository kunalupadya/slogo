package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.ResourceBundle;

/**
 * @author David Liu
 */

/**
 * Palettes Class that helps create and returns a VBox with two Panes within it, one for the label and one for
 * the actual content of the view
 * Depends on having a viable FrontendController class to communicate with it so that the controller can talk to the
 * backend
 * Example: Initialize Palettes with width 200 and height 250, with a moduleName of "Palettes" and a new FrontendController
 * object
 */
public class Palettes extends ListModule {
    private ResourceBundle myResourceBundles;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

    /**
     * Constructor of Palettes, sets up the two Panes that contains all the necessary content and labels
     * Also sets up the list associated with the view that will be displayed
     * Assumes that FrontendController class works as implemented - there is a viable FrontendController to communicate
     * with
     * @param width the Module width
     * @param height the Module height
     * @param moduleName the name of the Module
     * @param myFrontendController FrontendController object
     */
    public Palettes(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        list = getList();
        listCollection = getListCollection();
    }

    @Override
    protected void setPlaceholder() {
        myResourceBundles = getMyResourceBundles();
        listDisplay = getListDisplay();
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("Palettes")));
    }

    /**
     * Sets the list of palettes by adding the array of colors and it's indices to the list
     * @param myPalettes array of colors which correspond to the palettes
     */
    public void setPalettes(Color[] myPalettes) {
        listCollection.clear();
        list.clear();
        for (int i = 0; i < myPalettes.length; i++) {
            if (myPalettes[i] != null) {
                String index = myResourceBundles.getString("PaletteIndex") + (i + 1) + " " + myResourceBundles.getString("PaletteColor") + myPalettes[i];
                listCollection.add(index);
                list.add(index);
            }
        }
    }
}
