package GraphicsBackend;

import javafx.scene.image.ImageView;

/**
 * @author kunalupadya
 */
public interface ImmutableTurtle {

    public boolean getIsTurtleActive();

    public boolean isTurtleVisible();

    public double getyPos();

    public double getxPos();

    public Point getPos();

    public Grid getGrid();

    public int getMyShape();

    public double getMyAngle();

    public ImageView getAdjustedTurtleImageView(double xLeftCorner, double yLeftCorner);

    public ImmutablePen getMyPen();
}
