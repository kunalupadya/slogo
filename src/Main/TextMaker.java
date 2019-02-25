package Main;

import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * TODO: Modify this class so that all text comes from a config file
 *
 * @author Januario Carreiro
 */
public class TextMaker {

    /**
     * Method to generate text with the x-position and y-position of the text being relative to the window size.
     *
     * @param str   text to be displayed
     * @param font  font to be used
     * @param xPos  x position of this text box
     * @param yPos  y position of this text box
     * @return text box
     */
    public static Text makeText(String str, Font font, double xPos, double yPos) {
        Text text = textGenerator(str, font);
        text.setX(xPos - text.getLayoutBounds().getWidth()/2);
        text.setY(yPos - text.getLayoutBounds().getHeight()/2);
        return text;
    }

    /**
     * Method to generate text with the x-position and y-position of the text being relative to the parent node.
     *
     * @param str   text to be displayed
     * @param font  font to be used
     * @param xPos  x position of this text box
     * @param yPos  y position of this text box
     * @return text box
     */
    public static Text makeTextRelative(String str, Font font, double xPos, double yPos) {
        Text text = textGenerator(str, font);
        text.setLayoutX(xPos - text.getLayoutBounds().getWidth()/2);
        text.setLayoutY(yPos - text.getLayoutBounds().getHeight()/2);
        return text;
    }

    private static Text textGenerator(String str, Font font) {
        Text text = new Text();
        text.setText(str);
        text.setFont(font);
        return text;
    }
}
