package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import GUI.FrontendController;

public class MoveTurtle {
    private FrontendController context;
    private ResourceBundle myDirectionsResources;
    private MenuButton button;

    /**
     * TODO: Refactor so that all the buttons can extend control
     * TODO: Refactor this class so that all MenuItem objects are initialized in another method
     * TODO: Add setOnAction() for each MenuItem
     * @param context
     */
    public MoveTurtle(FrontendController context) {
        this.myDirectionsResources = ResourceBundle.getBundle("/buttonProperties/TurtleMovements");
        this.context = context;
        this.button = new MenuButton();

        ImageView img = new ImageView(new Image(FrontendController.class.getResourceAsStream("/images/moveTurtle.png")));
        img.setFitHeight(20.0);
        img.setFitWidth(20.0);
        button.setGraphic(img);
        button.getStyleClass().add("button");

        List<MenuItem> itemList = makeMenuItems();

        button.getItems().addAll(itemList);
    }

    private List<MenuItem> makeMenuItems() {
        EventHandler<ActionEvent> action = move();
        Enumeration<String> itemEnum = myDirectionsResources.getKeys();
        var itemList = new ArrayList<MenuItem>();

        while(itemEnum.hasMoreElements()) {
            String menuItemLabel = itemEnum.nextElement();
            MenuItem menuItem = new MenuItem(menuItemLabel);
            menuItem.setOnAction(action);
            itemList.add(menuItem);
        }

        return itemList;
    }

    private EventHandler<ActionEvent> move() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String command = myDirectionsResources.getString(mItem.getText());
            context.sendCommandString(command);
        };
    }

    public MenuButton getButton() {
        return button;
    }
}
