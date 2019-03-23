package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;

/**
 * Command turns turtle to an absolute heading.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class SetHeadingCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public SetHeadingCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws ExecutionException{
        if (getChildren().get(0).getReturnValue() < 0){
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        double oldAngle = turtle.getMyAngle();
        setReturnValue(Math.abs(getChildren().get(0).getReturnValue()-oldAngle));
        turtle.turnTo(getChildren().get(0).getReturnValue());
    }

}
