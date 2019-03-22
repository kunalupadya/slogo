package GraphicsBackend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * @author kunalupadya
 */
public interface ImmutableTurtle {

    public void setTurtleImage(Image turtleImage);

    public void setTurtleActive(boolean turtleActive);

    public void setPenColor(Color color);

    public void setPenSize(int pixelSize);

    public void setPenUp(boolean penUp);

    public boolean getIsTurtleActive();

    public boolean isTurtleVisible();

    public double getUserFriendlyXPos();

    public double getUserFriendlyYPos();

    public Point getPos();

    public Grid getGrid();

    public int getMyShape();

    public double getMyAngle();

    public ImageView getAdjustedTurtleImageView(double xLeftCorner, double yLeftCorner);

    public ImmutablePen getMyPen();
}
