package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author David Liu
 */

public class Palettes extends ListModule {
    private ResourceBundle myResourceBundles;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

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

    public void setPalettes(Color[] myPalettes) {
        listCollection.clear();
        list.clear();
        for (int i = 0; i < myPalettes.length; i++) {
            if (myPalettes[i] != null) {
                String index = myResourceBundles.getString("PaletteIndex") + i + " " + myResourceBundles.getString("PaletteColor") + myPalettes[i];
                listCollection.add(index);
                list.add(index);
            }
        }
    }
}
