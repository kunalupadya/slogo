package GUI.Modules;

import GUI.Controls.ButtonControl;
import GUI.FrontendController;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.util.List;
import java.util.ResourceBundle;

/**
 *
 */

public class GraphicsArea extends Module {
    private Pane toolbarPane;
    private ButtonControl close;
    private ResourceBundle myResourceBundles;
    private FrontendController context;
    private Pane content;

    public GraphicsArea(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        toolbarPane = getToolbarPane();
        close = getClose();
        myResourceBundles = getMyResourceBundles();
        context = getContext();
        content = getPane();
        toolbarPane.getChildren().remove(close.getButton());
    }

    @Override
    protected void setContent() {
    }

    public void setVariables(List<Line> lines, List<ImageView> turtleImages, List<Boolean> turtleActives) {
        content.getChildren().clear();
        for (Line n:lines){
            content.getChildren().add(n);
        }
        for (int i = 0; i < turtleImages.size(); i++) {
            ImageView turtle = turtleImages.get(i);
            if (turtleActives.get(i)) {
                //Fix this magic value?
                turtle.getStyleClass().add(myResourceBundles.getString("TurtleDropShadow"));
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
                turtle.getStyleClass().remove(myResourceBundles.getString("TurtleDropShadow"));
            }
            else {
                turtle.getStyleClass().add(myResourceBundles.getString("TurtleDropShadow"));
            }
            context.switchTurtleActive(turtleNumber);
            event.consume();
        });
    }
}
