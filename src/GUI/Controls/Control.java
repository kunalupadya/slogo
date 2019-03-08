package GUI.Controls;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Control {
    ImageView myImage;

    public Control(Image image) {
        myImage = new ImageView(image);
        myImage.setFitHeight(20.0);
        myImage.setFitWidth(20.0);
    }

    abstract EventHandler<?> action();

    /**
     * Setter method to change the myImage displayed on the myButton. In order for myImage to be compatible with the style
     * of the preset images, it should be a .png with a transparent background.
     *
     * @param file myImage file to replace myButton myImage
     */
    public void setImage(File file, ButtonBase button) {
        try {
            myImage = new ImageView(new Image(new FileInputStream(file.getPath())));
            myImage.setFitHeight(20.0);
            myImage.setFitWidth(20.0);
            button.setGraphic(myImage);
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "File not found.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
