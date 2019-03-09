package GUI.Controls;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import GUI.FrontendController;

public class SetPenColor{
    private final ColorPicker colorPicker;
    FrontendController context;

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

    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}
