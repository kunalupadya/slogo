package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command puts pen up such that when the turtle moves, it does not leave a trail.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class PenUpCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public PenUpCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        turtle.setPenUp(true);
        setReturnValue(0);
    }

}
