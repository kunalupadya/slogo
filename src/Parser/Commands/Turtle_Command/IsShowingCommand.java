package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class IsShowingCommand extends TurtleCommand {

    private static final int SHOWING = 1;
    private static final int HIDDEN = 0;

    /**
     * returns 1 if turtle is showing, 0 if it is hiding
     */
    public IsShowingCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }
    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.isTurtleVisible() ? SHOWING : HIDDEN);
    }

}
