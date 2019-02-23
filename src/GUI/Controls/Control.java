package GUI.Controls;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;

/**
 * Abstract superclass to serve as template for all buttons/controls
 *
 * @author Januario Carreiro
 */
public abstract class Control {
    private Button button;

    protected Control(Image image) {
        this.button = new Button();
        this.button.setGraphic(new ImageView(image));
        this.button.setBackground(Background.EMPTY);
        this.button.setOnMouseClicked(mouseEvent -> action());
    }

    protected abstract void action();

    /**
     * Getter method for the button associated with this class
     * @return Button contained by this class
     */
    public Button getButton() {
        return button;
    }
}

