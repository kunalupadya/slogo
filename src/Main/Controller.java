package Main;

import GUI.FrontendController;
import Parser.BackendController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
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
 * @author Januario Carreiro & David Liu
 */
public class Controller extends Application {
    private static final int WINDOW_HEIGHT = 450;
    private static final int WINDOW_WIDTH = 800;
    private static final Paint BACKGROUND = Color.ANTIQUEWHITE;
    private static final int FRAMES_PER_SECOND = 4;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private static final String WINDOW_TITLE = "Simple Logo";
    public static Font Aller_Bd, Aller_Lt, Aller_LtIt;
    private static final KeyCombination keyCombinationCommandN = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);

    /**
     * Start of the application that decides the font and launches the application
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
     * Start the application by setting up the front end and back end through setUpScene, creating the
     * FrontendController and BackendController
     * @param stage
     */
    public void start (Stage stage) {
        var root = new BorderPane();
        setUpScene(stage, root);
        root.setOnKeyPressed(event -> handleKeyInput(event));

        stage.show();
    }

    private void step(FrontendController front) {
        front.step();
    }

    private void setUpScene(Stage stage, BorderPane root) {
        FrontendController front = new FrontendController(root, stage);
        BackendController backendController = new BackendController();
        front.setBackendController(backendController);
        backendController.setFrontendController(front);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(WINDOW_TITLE);

        stage.setResizable(true);

        stage.setMinHeight(430);
        stage.setMinWidth(400);

        stage.setMaxHeight(585);
        stage.setMaxWidth(800);

        var frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(front));
        var animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();

        scene.getStylesheets().add("ControlStyle.css");
    }

    private void handleKeyInput(KeyEvent e) {
        if (keyCombinationCommandN.match(e)) {
            Stage stage = new Stage();
            var root = new BorderPane();
            setUpScene(stage, root);
            stage.show();
        }
    }
}