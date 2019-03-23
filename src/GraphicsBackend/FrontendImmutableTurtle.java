package GraphicsBackend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * the turtle interface used by the frontend
 * @author kunalupadya
 */
public interface FrontendImmutableTurtle {

    void setTurtleImage(Image turtleImage);

    void setTurtleActive(boolean turtleActive);

    void setPenColor(Color color);

    void setPenSize(int pixelSize);

    void setPenUp(boolean penUp);

    boolean getIsTurtleActive();

    boolean isTurtleVisible();

    double getUserFriendlyXPos();

    double getUserFriendlyYPos();

    Point getPos();

    Grid getGrid();

    int getMyShape();

    double getMyAngle();

    ImageView getAdjustedTurtleImageView(double xLeftCorner, double yLeftCorner);

    ImmutablePen getMyPen();
}
