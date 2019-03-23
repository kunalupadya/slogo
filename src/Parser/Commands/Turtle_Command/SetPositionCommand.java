package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;

/**
 * Command moves turtle to an absolute screen position, where (0, 0) is the center of the screen.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SetPositionCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public SetPositionCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws ExecutionException{
        Point newPos =  new Point(getChildren().get(0).getReturnValue(), getChildren().get(1).getReturnValue());
        setReturnValue(distance(turtle.getPos(),newPos));
        turtle.moveTo(newPos);
    }

}
