package GUI.Controls;

import javafx.scene.control.ColorPicker;

import GUI.WindowLayout;

public class SetBackgroundColor {
    private WindowLayout context;
    final ColorPicker colorPicker;

    public SetBackgroundColor(WindowLayout context) {
        this.context = context;
        this.colorPicker = new ColorPicker();

        colorPicker.setId("backgroundColor");
        colorPicker.getStyleClass().add("button");
        colorPicker.setOnAction(event -> action());
    }

    public void action() {
        context.setBackgroundColor();
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}
