package GUI.Controls;

import GUI.WindowLayout;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;

public class SwitchLanguages {
    private WindowLayout context;
    private MenuButton button;
    private ImageView img;
    private MenuItem chinese, english, french, german, italian, portuguese, russian, spanish, urdu;

    /**
     * TODO: Refactor so that all the buttons can extend control
     * TODO: Refactor this class so that all MenuItem objects are initialized in another method
     * TODO: Add setOnAction() for each MenuItem
     * @param context
     */
    public SwitchLanguages(WindowLayout context) {
        this.button = new MenuButton();

        img = new ImageView(new Image(WindowLayout.class.getResourceAsStream("/images/language.png")));
        img.setFitHeight(20.0);
        img.setFitWidth(20.0);
        this.button.setGraphic(img);
        this.button.getStyleClass().add("button");

        chinese = new MenuItem("Chinese");
        english = new MenuItem("English");
        french = new MenuItem("French");
        german = new MenuItem("German");
        italian = new MenuItem("Italian");
        portuguese = new MenuItem("Portuguese");
        russian = new MenuItem("Russian");
        spanish =  new MenuItem("Spanish");
        urdu = new MenuItem("Urdu");

        button.getItems().addAll(chinese, english, french, german, italian, portuguese, russian, spanish, urdu);

        this.context = context;
        this.button.setOnMouseClicked(mouseEvent -> action());
    }

    public MenuButton getButton() {
        return button;
    }

    private void action() {
    }
}
