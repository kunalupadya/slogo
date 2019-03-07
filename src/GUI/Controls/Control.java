package GUI.Controls;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Control {
    javafx.scene.control.ButtonBase button;
    ImageView img;

    /**
     *
     */
    private void action() {};

    /**
     * Setter method to change the image displayed on the button. In order for image to be compatible with the style
     * of the preset images, it should be a .png with a transparent background.
     *
     * @param file image file to replace button image
     */
    public void setImage(File file) {
        try {
            img = new ImageView(new Image(new FileInputStream(file.getPath())));
            img.setFitHeight(20.0);
            img.setFitWidth(20.0);
            this.button.setGraphic(img);
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "File not found.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
