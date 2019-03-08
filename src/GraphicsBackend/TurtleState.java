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

    public double getAngle() {
        return angle;
    }

    public Point getPos() {
        return pos;
    }
}
