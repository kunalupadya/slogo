package Main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * TODO: rename this class to Controller???
 * TODO: add step() for animation
 *
 * NOTE: We can take different screens in many different directions If we want there to be an input to exit any menu
 *      at any time, then we can add a handleKeyInput() method to the scene. If a certain Key is pressed, the
 *      current screen closes and the user is returned to the main screen.
 *
 * Controller class for SLogo.
 *
 * @author Januario Carreiro
 */
public class Driver extends Application {
    private static final int WINDOW_HEIGHT = 900;
    private static final int WINDOW_WIDTH = 1600;
    private static final Paint BACKGROUND = Color.ANTIQUEWHITE;
    private static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private static final String WINDOW_TITLE = "Simple Logo";
    public static Font Aller_Bd, Aller_Lt, Aller_LtIt;
    private Scene myScene;
    private Stage myStage;

    public static void main (String[] args) {
        try {
            Aller_Bd = Font.loadFont(Driver.class.getResource("/fonts/Aller_Bd.tff").openStream(), 30);
            Aller_Lt = Font.loadFont(Driver.class.getResource("/fonts/Aller_Lt.tff").openStream(), 20);
            Aller_LtIt = Font.loadFont(Driver.class.getResource("/fonts/Aller_LtIt.tff").openStream(), 20);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }

    public void start (Stage stage) {
        var root = new Group();
        myScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, BACKGROUND);
        stage.setScene(myScene);
        stage.setTitle(WINDOW_TITLE);
        stage.show();
    }
}