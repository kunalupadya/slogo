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
 * Controller class for SLogo.
 *
 * @author Januario Carreiro & David Liu
 */
public class Controller extends Application {
    private static final int WINDOW_MAX_HEIGHT = 585;
    private static final int WINDOW_MIN_HEIGHT = 430;
    private static final int WINDOW_MIN_WIDTH = 400;
    private static final int WINDOW_MAX_WIDTH = 800;
    private static final Paint BACKGROUND = Color.ANTIQUEWHITE;
    private static final int FRAMES_PER_SECOND = 4;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private static final String WINDOW_TITLE = "Simple Logo";
    private static final KeyCombination keyCombinationCommandN = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);

    /**
     * Start of the application that decides the font and launches the application
     * @param args args
     */
    public static void main (String[] args) {
        launch(args);
    }

    /**
     * Start the application by setting up the front end and back end through setUpScene, creating the
     * FrontendController and BackendController
     * @param stage stage
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

        stage.setMinHeight(WINDOW_MIN_HEIGHT);
        stage.setMinWidth(WINDOW_MIN_WIDTH);

        stage.setMaxHeight(WINDOW_MAX_HEIGHT);
        stage.setMaxWidth(WINDOW_MAX_WIDTH);

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