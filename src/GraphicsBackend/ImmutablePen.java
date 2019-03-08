package GraphicsBackend;

import javafx.scene.paint.Color;

public interface ImmutablePen {

    public Color getMyPenColor();

    public boolean getPenUp();

    public int getPenSize();
}
