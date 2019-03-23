package Parser.Commands;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.SLogoException;

/**
 * @author kunalupadya
 * @author Louis Lee
 */

public abstract class TurtleCommand extends Command{

    protected boolean turtleQuery = false;

    public void execute(BackendController backendController, Turtle currTurtle) throws SLogoException {
        performAction(backendController, currTurtle);
        setIsEvaluated(true);
    }

    public boolean isTurtleQuery(){
        return turtleQuery;
    }

    protected double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getMyX() - point2.getMyX(), 2) + Math.pow(point1.getMyY() - point2.getMyY(), 2));
    }

    protected abstract void performAction(BackendController backendController, Turtle turtle) throws SLogoException;
}
