package GUI.Modules;

import GUI.WindowLayout;
import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Main.BackendController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.List;

/**
 * TODO: Decide whether to have a global step based on a Timeline, or a local one only for the GraphicsArea
 * TODO: How to initialize the grid and get the initial state, and be able to update it as a step
 */

public class GraphicsArea extends Module {
    private Pane container;
    private Grid grid;
    private double FRAMES_PER_SECOND = 0.5;
    private double MILLISECOND_IN_A_SECOND = 1000;
    private double MILLISECOND_DELAY = MILLISECOND_IN_A_SECOND / FRAMES_PER_SECOND;
    private Timeline animation;

    public GraphicsArea(int width, int height, WindowLayout myWindowLayout) {
        super(width, height, myWindowLayout);
        startAnimation(MILLISECOND_DELAY);
        setContent();
    }

    @Override
    protected void setStyle(){
    }

    @Override
    protected void setContent() {
        container = new Pane();
        content.setContent(container);
    }

    private void startAnimation(double delay) {
        var frame = new KeyFrame(Duration.millis(delay), e -> step());
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    public void setVariables(List<Line> lines, List<ImageView> turtleImages) {
        for (Line n:lines){
            container.getChildren().add(n);
        }
        for (ImageView image : turtleImages) {
            container.getChildren().add(image);
        }
    }

    private void step() {
        //How do you update the grid?
        //Is it through add movement or getallobjects or something different?
    }
}
