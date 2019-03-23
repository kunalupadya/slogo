package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class RightCommand extends TurtleCommand {

    public RightCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws ExecutionException {
        turtle.turn(getChildren().get(0).getReturnValue());
        setReturnValue(getChildren().get(0).getReturnValue());
    }

}
