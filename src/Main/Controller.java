package Main;

import GUI.WindowLayout;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
    private WindowLayout windowLayout;
    private static final int WINDOW_HEIGHT = 450;
    private static final int WINDOW_WIDTH = 800;
    private static final Paint BACKGROUND = Color.ANTIQUEWHITE;
    private static final int FRAMES_PER_SECOND = 1;
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
            Aller_Bd = Font.loadFont(Controller.class.getResource("/fonts/Aller_Bd.ttf").openStream(), 15);
            Aller_Lt = Font.loadFont(Controller.class.getResource("/fonts/Aller_Lt.ttf").openStream(), 12);
            Aller_LtIt = Font.loadFont(Controller.class.getResource("/fonts/Aller_LtIt.ttf").openStream(), 12);
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
        var root = new BorderPane();
        windowLayout = new WindowLayout(root, stage);
        BackendController backendController = new BackendController();
        windowLayout.setBackendController(backendController);
        backendController.setWindowLayout(windowLayout);

        myScene = new Scene(root);
        stage.setScene(myScene);
        stage.setTitle(WINDOW_TITLE);
        stage.show();

        var frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
        var animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();

        myScene.getStylesheets().add("ControlStyle.css");
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

    private void step(double elapsedTime) {
        windowLayout.step();
    }
}