package GUI.Controls;

import javafx.scene.control.ColorPicker;

/**
 * TODO: Remove action() once BackEnd.Pen is complete
 */
public class SetPenColor{
    final ColorPicker colorPicker;

    protected SetPenColor() {
        colorPicker = new ColorPicker();
        colorPicker.getStyleClass().add("button");
//        colorPicker.setValue(BackEnd.Pen.getColor());
        colorPicker.setOnAction(event -> action());
    }

    protected void action() {
//        Backend.ExecuteCommand().setPenColor();
    }
}
