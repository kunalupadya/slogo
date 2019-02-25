package Main;

import GUI.WindowLayout;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * TODO: rename this class to Controller???
 * TODO: add step() for animation
 *
 * NOTE: We can take different screens in many different directions. If we want there to be an input to exit any menu
 *      at any time, then we can add a handleKeyInput() method to the scene. If a certain Key is pressed, the
 *      current screen closes and the user is returned to the main screen.
 *
 * Controller class for SLogo.
 *
 * @author Januario Carreiro
 */
public class Controller extends Application {
    private static final int WINDOW_HEIGHT = 900;
    private static final int WINDOW_WIDTH = 1600;
    private static final Paint BACKGROUND = Color.ANTIQUEWHITE;
    private static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private static final String WINDOW_TITLE = "Simple Logo";
    public static Font Aller_Bd, Aller_Lt, Aller_LtIt;
    private Scene myScene;

    /**
     * TODO: add JavaDoc
     * @param args
     */
    public static void main (String[] args) {
        try {
            Aller_Bd = Font.loadFont(Controller.class.getResource("/fonts/Aller_Bd.tff").openStream(), 30);
            Aller_Lt = Font.loadFont(Controller.class.getResource("/fonts/Aller_Lt.tff").openStream(), 20);
            Aller_LtIt = Font.loadFont(Controller.class.getResource("/fonts/Aller_LtIt.tff").openStream(), 20);
        }
        catch (Exception e) {
            // TODO: change from printStackTrace() to something more useful
            e.printStackTrace();
        }
        launch(args);
    }

    /**
     * TODO: add JavaDoc
     * @param stage
     */
    public void start (Stage stage) {
        var root = new Group();
        myScene = initSetup(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(myScene);
        stage.setTitle(WINDOW_TITLE);
        stage.show();
//
//        TODO: add step() to GUI.Windows.GraphicsArea?
//
//        var frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
//        var animation = new Timeline();
//        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.getKeyFrames().add(frame);
//        animation.play();
//
    }

    private Scene initSetup(Group root, int width, int height) {
        var scene = new Scene(root, width, height, Color.ANTIQUEWHITE);
        WindowLayout windowLayout = new WindowLayout(scene, this);
        ((Group) scene.getRoot()).getChildren().add(windowLayout.getContainer());

        return scene;
    }
}