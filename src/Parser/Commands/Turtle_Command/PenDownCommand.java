package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command puts pen down such that when the turtle moves, it leaves a trail.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class PenDownCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public PenDownCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        turtle.setPenUp(false);
        setReturnValue(1);
    }

}
