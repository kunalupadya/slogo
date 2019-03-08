package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Abstract superclass to serve as template for all buttons/controls
 * TODO: finish JavaDoc
 *
 * @author Januario Carreiro
 */
public abstract class ButtonControl extends Control{
    Button myButton;

    /**
     * TODO: finish JavaDoc
     * @param image
     */
    public ButtonControl(Image image) {
        super(image);
        this.myButton = new Button();

        myButton.setGraphic(myImage);
        myButton.setOnMouseClicked(action());
    }

    @Override
    protected abstract EventHandler<MouseEvent> action();

    public Button getButton() {
        return myButton;
    }
}

