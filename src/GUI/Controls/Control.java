package GUI.Controls;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Abstract superclass to serve as template for all buttons/controls
 * TODO: finish JavaDoc
 *
 * @author Januario Carreiro
 */
public abstract class Control {
    Button button;
    ImageView img;

    /**
     * TODO: finish JavaDoc
     * @param image
     */
    public Control(Image image) {
        this.button = new Button();

        img = new ImageView(image);
        img.setFitHeight(20.0);
        img.setFitWidth(20.0);
        this.button.setGraphic(img);

        this.button.setOnMouseClicked(mouseEvent -> action());
    }

    protected abstract void action();

    /**
     * Getter method for the button associated with this class
     *
     * @return Button contained by this class
     */
    public Button getButton() {
        return button;
    }

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

