package GUI.Controls;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Abstract superclass to serve as template for all buttons/controls. This superclass is expands on Control superclass.
 * Should be used for creating new Button objects.
 *
 * @author Januario Carreiro
 */
public abstract class ButtonControl extends Control{
    Button myButton;

    /**
     * Creates button instance and calls superclass to set graphic.
     *
     * @param image graphic for button
     */
    public ButtonControl(Image image) {
        super(image);
        this.myButton = new Button();

        myButton.setGraphic(myImage);
        myButton.setOnMouseClicked(action());
    }

    @Override
    protected abstract EventHandler<MouseEvent> action();

    /**
     * Returns button object
     *
     * @return this button
     */
    public Button getButton() {
        return myButton;
    }
}

