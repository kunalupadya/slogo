package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Palettes extends ListModule {
    private VBox container;

    public Palettes(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Palettes", myFrontendController);
    }

    @Override
    public void setPlaceholder() {
        listDisplay.setPlaceholder(new Label("Palettes"));
    }

    public void setPalettes(Color[] myPalettes) {
        listCollection.clear();
        list.clear();
        for (int i = 0; i < myPalettes.length; i++) {
            if (myPalettes[i] != null) {
                String index = "Index: " + i + " Color: " + myPalettes[i];
                listCollection.add(index);
                list.add(index);
            }
        }
    }
}
