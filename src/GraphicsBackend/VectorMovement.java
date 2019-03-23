package GraphicsBackend;

import javafx.scene.shape.Line;

import java.util.List;

/**
 * @author kunalupadya
 */
public class VectorMovement{
    Point position;
    List<Line> linesAssociatedWithMovement;
    VectorMovement(Point position, List<Line> linesAssociatedWithMovement){
        this.linesAssociatedWithMovement = linesAssociatedWithMovement;
        this.position = position;
    }

    /**
     * gets lines
     * @return
     */
    public List<Line> getLinesAssociatedWithMovement() {
        return linesAssociatedWithMovement;
    }

    /**
     * gets position
     * @return
     */
    public Point getPosition() {
        return position;
    }
}
