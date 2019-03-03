package GUI.Controls;

import javafx.scene.control.ColorPicker;

import GUI.WindowLayout;
import javafx.scene.paint.Paint;

public class SetBackgroundColor {
    private WindowLayout context;
    final ColorPicker colorPicker;

    public SetBackgroundColor(WindowLayout context) {
        this.context = context;
        this.colorPicker = new ColorPicker();

        colorPicker.setId("backgroundColor");
        colorPicker.getStyleClass().add("button");
        colorPicker.setOnAction(event -> action(colorPicker.getValue()));
    }

    public void action(Paint color) {
        context.setBackgroundColor(color);
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}
