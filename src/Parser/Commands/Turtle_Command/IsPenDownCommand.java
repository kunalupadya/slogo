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

public class IsPenDownCommand extends TurtleCommand {

    private static final int PEN_DOWN = 1;
    private static final int PEN_UP = 0;

    /**
     * returns 0 if pen is up and 1 if pen is down
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
