package GraphicsBackend;

import javafx.scene.shape.Line;

import java.util.List;

public interface ImmutableGrid {
    public void clear();

    public List<Line> getAllObjects();
}
