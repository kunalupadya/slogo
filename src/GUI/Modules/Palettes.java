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

public class Palettes extends Module {
    private VBox container;
    private List<String> palettes;
    private ListView<String> palettesDisplay;
    private ObservableList<String> palettesCollection;

    public Palettes(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Palettes", myFrontendController);
        palettes = new ArrayList<>();
        setContent();
    }

    @Override
    protected void setContent() {
        container = new VBox();
//        content.setContent(container);
        container.prefHeightProperty().bind(content.heightProperty());
        if (palettes != null) {
            palettesCollection = FXCollections.<String>observableArrayList(palettes);
            palettesDisplay = new ListView<>(palettesCollection);
            palettesDisplay.setOrientation(Orientation.VERTICAL);
            palettesDisplay.prefHeightProperty().bind(container.heightProperty());
            palettesDisplay.setPrefWidth(moduleWidth);
            palettesDisplay.setPlaceholder(new Label("Palettes"));
        }
        container.getChildren().add(palettesDisplay);
        content.getChildren().add(container);
    }

    public void setPalettes(Color[] myPalettes) {
        palettesCollection.clear();
        palettes.clear();
        for (int i = 0; i < myPalettes.length; i++) {
            if (myPalettes[i] != null) {
                String index = "Index: " + i + " Color: " + myPalettes[i];
                palettesCollection.add(index);
                palettes.add(index);
            }
        }
    }
}
