package GUI.Modules;

import GUI.FrontendController;
import GraphicsBackend.Grid;
import javafx.animation.Timeline;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.util.List;

/**
 * TODO: Decide whether to have a global step based on a Timeline, or a local one only for the GraphicsArea
 * TODO: How to initialize the grid and get the initial state, and be able to update it as a step
 */

public class GraphicsArea extends Module {
    private Grid grid;
    private double FRAMES_PER_SECOND = 0.5;
    private double MILLISECOND_IN_A_SECOND = 1000;
    private double MILLISECOND_DELAY = MILLISECOND_IN_A_SECOND / FRAMES_PER_SECOND;
    private Timeline animation;

    public GraphicsArea(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Turtle Display", myFrontendController);
        setContent();
    }

    @Override
    protected void setContent() {
//        content.setMinWidth(moduleWidth);
//        content.setMinHeight(moduleHeight);
//        content.setOnKeyReleased(event -> context.handleKeyInput(event.getCode()));
    }

    public void setVariables(List<Line> lines, List<ImageView> turtleImages, List<Boolean> turtleActives) {
        content.getChildren().clear();
        for (Line n:lines){
            content.getChildren().add(n);
        }
        for (int i = 0; i < turtleImages.size(); i++) {
            ImageView turtle = turtleImages.get(i);
            Boolean turtleActive = turtleActives.get(i);
            if (turtleActives.get(i)) {
                //Fix this magic value?
                turtle.getStyleClass().add("turtle-shadow");
            }
            content.getChildren().add(turtle);
            setClick(turtle, i);
        }
    }

    private String colorToHex(Paint color) {
        String hex1;
        String hex2;

        hex1 = Integer.toHexString(color.hashCode()).toUpperCase();

        switch (hex1.length()) {
            case 2:
                hex2 = "000000";
                break;
            case 3:
                hex2 = String.format("00000%s", hex1.substring(0,1));
                break;
            case 4:
                hex2 = String.format("0000%s", hex1.substring(0,2));
                break;
            case 5:
                hex2 = String.format("000%s", hex1.substring(0,3));
                break;
            case 6:
                hex2 = String.format("00%s", hex1.substring(0,4));
                break;
            case 7:
                hex2 = String.format("0%s", hex1.substring(0,5));
                break;
            default:
                hex2 = hex1.substring(0, 6);
        }
        return hex2;
    }

    public void setColor(Paint color) {
        String hexColor = colorToHex(color);
        content.setStyle("-fx-background-color: #" + hexColor);
    }

    private void setClick(ImageView turtle, int turtleNumber) {
        turtle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (turtle.getStyleClass().size() > 1) {
                turtle.getStyleClass().remove("turtle-shadow");
            }
            else {
                turtle.getStyleClass().add("turtle-shadow");
            }
            context.switchTurtleActive(turtleNumber);
            event.consume();
        });
    }
}
