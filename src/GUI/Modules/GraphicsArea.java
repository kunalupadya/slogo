package GUI.Modules;

import GraphicsBackend.Grid;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * TODO: Decide whether to have a global step based on a Timeline, or a local one only for the GraphicsArea
 */

public class GraphicsArea extends Module {
    private VBox container;
    private Grid grid;
    private double FRAMES_PER_SECOND = 0.5;
    private double MILLISECOND_IN_A_SECOND = 1000;
    private double MILLISECOND_DELAY = MILLISECOND_IN_A_SECOND / FRAMES_PER_SECOND;
    private Timeline animation;

    public GraphicsArea(int width, int height) {
        super(width, height);
        startAnimation(MILLISECOND_DELAY);
        setContent();
    }

    @Override
    protected void setLayout() {
    }

    @Override
    protected void setStyle(){
    }

    @Override
    protected void setContent() {
        content.setContent(container);
        grid = new Grid(moduleWidth, moduleWidth);
        //grid.getAllObjects();
        //How to initialize the grid here and get the initial state
    }

    private void startAnimation(double delay) {
        var frame = new KeyFrame(Duration.millis(delay), e -> step());
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void step() {
        //How do you update the grid?
        //Is it through add movement or getallobjects or something different?
    }
}
