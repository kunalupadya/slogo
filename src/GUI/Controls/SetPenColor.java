package GUI.Controls;

import javafx.scene.control.ColorPicker;

/**
 * TODO: add JavaDoc
 */
public class SetPenColor{
    final ColorPicker colorPicker;

    public SetPenColor() {
        colorPicker = new ColorPicker();
        colorPicker.setId("penColor");
        colorPicker.getStyleClass().add("button");
        colorPicker.setOnAction(event -> action());
    }

    protected void action() {
//        Parser.ExecuteCommand().setPenColor();
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}
