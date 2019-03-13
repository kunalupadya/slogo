package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Control {
    ImageView myImage;
    FrontendController myContext;
    private final double imageSize = 20.0;

    public Control(Image image, FrontendController context) {
        this.myImage = new ImageView(image);
        this.myContext = context;

        myImage.setFitHeight(imageSize);
        myImage.setFitWidth(imageSize);
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
            myImage.setFitHeight(imageSize);
            myImage.setFitWidth(imageSize);
            button.setGraphic(myImage);
        } catch (FileNotFoundException e) {
            myContext.consoleShowError("Error occurred when changing button image");
        }
    }
}
