package GraphicsBackend;

import javafx.scene.paint.Color;

/**
 * @author kunalupadya
 */
public interface ImmutablePen {

    public Color getMyPenColor();

    public boolean getPenUp();

    public int getPenSize();
}
