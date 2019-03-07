package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Palettes extends ListModule {

    public Palettes(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Palettes", myFrontendController);
    }

    @Override
    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label(myResourceBundles.getString("Palettes")));
    }

    public void setPalettes(Color[] myPalettes) {
        listCollection.clear();
        list.clear();
        for (int i = 0; i < myPalettes.length; i++) {
            if (myPalettes[i] != null) {
                String index = myResourceBundles.getString("PaletteIndex") + i + myResourceBundles.getString("PaletteColor") + myPalettes[i];
                listCollection.add(index);
                list.add(index);
            }
        }
    }
}
