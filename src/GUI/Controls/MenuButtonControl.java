package GUI.Controls;

import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class MenuButtonControl extends Control {

    public MenuButtonControl(Image image) {
        this.button = new MenuButton();

        img = new ImageView(image);
        img.setFitHeight(20.0);
        img.setFitWidth(20.0);
        this.button.setGraphic(img);

        this.button.setOnMouseClicked(mouseEvent -> action());
    }

    protected abstract void action();

    /**
     * Getter method for the button associated with this class
     *
     * @return Button contained by this class
     */
    public MenuButton getButton() {
        return (MenuButton) button;
    }
}
