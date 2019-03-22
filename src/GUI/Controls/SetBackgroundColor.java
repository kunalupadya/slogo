package GUI.Controls;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import GUI.FrontendController;

/**
 * Button to set background color of graphics area
 */
public class SetBackgroundColor {
    private FrontendController context;
    final ColorPicker colorPicker;

    /**
     * @param context where this button is located
     */
    public SetBackgroundColor(FrontendController context) {
        this.context = context;
        this.colorPicker = new ColorPicker();

        colorPicker.setId("backgroundColor");
        colorPicker.getStyleClass().add("button");
        colorPicker.setOnAction(event -> action(colorPicker.getValue()));
    }

    /**
     * Action Event to call method in context to change background color
     *
     * @param color
     */
    public void action(Color color) {
        context.setBackgroundColor(color);
    }

    /**
     * Getter method for this object
     *
     * @return this colorPicker
     */
    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}
