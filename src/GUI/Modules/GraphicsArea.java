package GUI.Modules;

import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Main.BackendController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

/**
 * TODO: Decide whether to have a global step based on a Timeline, or a local one only for the GraphicsArea
 * TODO: How to initialize the grid and get the initial state, and be able to update it as a step
 */

public class GraphicsArea extends Module {
    private VBox container;
    private Grid grid;
    private double FRAMES_PER_SECOND = 0.5;
    private double MILLISECOND_IN_A_SECOND = 1000;
    private double MILLISECOND_DELAY = MILLISECOND_IN_A_SECOND / FRAMES_PER_SECOND;
    private Timeline animation;
    private List<Node> gridObjects;
    private BackendController backendController;

    public GraphicsArea(int width, int height) {
        super(width, height);
        startAnimation(MILLISECOND_DELAY);
        setContent();
    }

    public void setBackendController(BackendController backendController) {
        this.backendController = backendController;
    }

    @Override
    protected void setLayout() {
    }

    @Override
    protected void setStyle(){
    }

    @Override
    protected void setContent() {
        container = new VBox();
        content.setContent(container);
        grid = new Grid(moduleHeight, moduleWidth);
        gridObjects = grid.getAllObjects();
        container.getChildren().addAll(gridObjects);
    }

    private void startAnimation(double delay) {
        var frame = new KeyFrame(Duration.millis(delay), e -> step());
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    public void updateGraphicsArea(List<Turtle> turtles){
        for (Turtle turtle:turtles){
            container.getChildren().add(turtle.getAdjustedTurtleImageView(10,10));
        }
    }

    private void step() {
        //How do you update the grid?
        //Is it through add movement or getallobjects or something different?
    }
}
