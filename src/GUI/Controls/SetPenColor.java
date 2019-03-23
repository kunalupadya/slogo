package GUI.Controls;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import GUI.FrontendController;

/**
 * Button to set pen color.
 */
public class SetPenColor{
    private final ColorPicker colorPicker;
    FrontendController context;

    /**
     * @param context where this button is located
     */
    public SetPenColor(FrontendController context) {
        this.context = context;
        this.colorPicker = new ColorPicker();

        colorPicker.setId("penColor");
        colorPicker.getStyleClass().add("button");
        colorPicker.setOnAction(event -> action(colorPicker.getValue()));
    }

    protected void action(Color color) {
        context.setPenColor(color);
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
