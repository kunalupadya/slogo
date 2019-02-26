package GUI.Controls;

import javafx.scene.control.ColorPicker;

public class SetBackgroundColor {
    final ColorPicker colorPicker;

    public SetBackgroundColor() {
        colorPicker = new ColorPicker();
        colorPicker.setId("backgroundColor");
        colorPicker.getStyleClass().add("button");
        colorPicker.setOnAction(event -> action());
    }

    public void action() {}

    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}
