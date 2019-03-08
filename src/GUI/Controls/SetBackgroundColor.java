package GUI.Controls;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Paint;

import GUI.FrontendController;

public class SetBackgroundColor {
    private FrontendController context;
    final ColorPicker colorPicker;

    public SetBackgroundColor(FrontendController context) {
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
