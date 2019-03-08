package GraphicsBackend;

import javafx.scene.shape.Line;

import java.util.List;

/**
 * @author kunalupadya
 */
public interface ImmutableGrid {
    public void clear();

    public List<Line> getAllObjects();
}