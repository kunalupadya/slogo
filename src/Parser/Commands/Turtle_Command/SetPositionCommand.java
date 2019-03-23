package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
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


public class SetPositionCommand extends TurtleCommand {

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
