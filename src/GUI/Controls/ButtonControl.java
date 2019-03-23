package GUI.Controls;

import GUI.FrontendController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
     * @param buttonClassName name of button
     */
    public ButtonControl(String buttonClassName, FrontendController context) {
        super(buttonClassName, context);
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

