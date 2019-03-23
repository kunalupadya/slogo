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


public class PenUpCommand extends TurtleCommand {

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
