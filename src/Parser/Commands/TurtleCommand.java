package Parser.Commands;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.SLogoException;

/**
 * This abstract class is for all sub command classes that require a turtle to execute.
 *
 * @author kunalupadya
 * @author Louis Lee
 */
public abstract class TurtleCommand extends Command{

    protected boolean turtleQuery = false;

    /**
     * Evaluates command.
     *
     * @param backendController backendController
     * @param turtle turtle to execute command on
     * @throws SLogoException exception that may occur in evaluation
     */
    public void execute(BackendController backendController, Turtle turtle) throws SLogoException {
        performAction(backendController, turtle);
        setIsEvaluated(true);
    }

    /**
     * Returns whether TurtleCommand is a Turtle Query.
     *
     * @return if command is a turtleQuery
     */
    public boolean isTurtleQuery(){
        return turtleQuery;
    }

    protected abstract void performAction(BackendController backendController, Turtle turtle) throws SLogoException;
}
