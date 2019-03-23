package GraphicsBackend;

import javafx.scene.paint.Color;

/**
 * an immutable interface for the pen
 * @author kunalupadya
 */
public interface ImmutablePen {

    Color getMyPenColor();

    boolean getPenUp();

    int getPenSize();
}
