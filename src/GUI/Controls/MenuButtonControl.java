package GUI.Controls;

import GUI.FrontendController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Abstract superclass to serve as template for all buttons/controls. This superclass is expands on Control superclass.
 * Should be used for creating new MenuButton objects.
 *
 * @author Januario Carreiro
 */
public abstract class MenuButtonControl extends Control {
    ResourceBundle myResourceBundle;
    private MenuButton myButton;

    public MenuButtonControl(Image image, FrontendController context,String resourceBundlePath) {
        super(image, context);
        this.myButton = new MenuButton();
        this.myResourceBundle = ResourceBundle.getBundle(resourceBundlePath);

        this.myButton.setGraphic(myImage);

        myButton.getStyleClass().add("button");

        List<MenuItem> itemList = makeMenuItems();

        myButton.getItems().addAll(itemList);
    }

    private List<MenuItem> makeMenuItems() {
        Enumeration<String> itemEnum = myResourceBundle.getKeys();
        var itemList = new ArrayList<MenuItem>();

        while(itemEnum.hasMoreElements()) {
            String menuItemLabel = itemEnum.nextElement();
            MenuItem menuItem = new MenuItem(menuItemLabel);
            menuItem.setOnAction(action());
            itemList.add(menuItem);
        }

        return itemList;
    }

    @Override
    protected abstract EventHandler<ActionEvent> action();

    /**
     * Getter method for the myButton associated with this class
     *
     * @return Button contained by this class
     */
    public MenuButton getButton() {
        return myButton;
    }

    /**
     * Sets resourceBundle for this menuButton in case the resource bundle needs to be changed.
     *
     * @param resourceBundleName name of resourceBundle
     */
    public abstract void setResourceBundle(String resourceBundleName);
}
