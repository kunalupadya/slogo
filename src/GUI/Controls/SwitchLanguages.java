package GUI.Controls;

import GUI.WindowLayout;
import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.event.ActionEvent;

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

        EventHandler<ActionEvent> action = changeLanguage();

        chinese = new MenuItem("Chinese");
        chinese.setOnAction(action);

        english = new MenuItem("English");
        english.setOnAction(action);

        french = new MenuItem("French");
        french.setOnAction(action);

        german = new MenuItem("German");
        german.setOnAction(action);

        italian = new MenuItem("Italian");
        italian.setOnAction(action);

        portuguese = new MenuItem("Portuguese");
        portuguese.setOnAction(action);

        russian = new MenuItem("Russian");
        russian.setOnAction(action);

        spanish =  new MenuItem("Spanish");
        spanish.setOnAction(action);

        urdu = new MenuItem("Urdu");
        urdu.setOnAction(action);

        button.getItems().addAll(chinese, english, french, german, italian, portuguese, russian, spanish, urdu);

        this.context = context;
        this.button.setOnMouseClicked(mouseEvent -> action());
    }

    public MenuButton getButton() {
        return button;
    }

    private void action() {
    }

    private EventHandler<ActionEvent> changeLanguage() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String language = mItem.getText();
            context.changeLanguage(language);
            System.out.println(language); // TODO: Remove once this is working
        };
    }
}
