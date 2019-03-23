package GraphicsBackend;

/**
 * @author kunalupadya
 */
public class TurtleState implements ImmutableTurtleState{
    Point pos;
    double angle;

    public TurtleState(Point pos, double angle){
        this.angle = angle;
        this.pos = pos;
    }

    /**
     * gets angle
     * @return
     */
    public double getAngle() {
        return angle;
    }

    /**
     * gets position
     * @return
     */
    public Point getPos() {
        return pos;
    }
}
