package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command returns 1 if turtle's pen is down, 0 if it is up.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class IsPenDownCommand extends TurtleCommand {

    private static final int PEN_DOWN = 1;
    private static final int PEN_UP = 0;

    /**
     * Command Constructor
     */
    public IsPenDownCommand(){
        isOutputCommand = true;
        setNumParameters(0);
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getMyPen().getPenUp() ? PEN_UP : PEN_DOWN);
    }
}
