package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;

/**
 * Command turns turtle to face the point (x, y), where (0, 0) is the center of the screen.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SetTowardsCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public SetTowardsCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws ExecutionException{
        if (getChildren().get(0).getReturnValue() < 0 || getChildren().get(1).getReturnValue() < 0){
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        double oldAngle = turtle.getMyAngle();
        double xDiff = getChildren().get(0).getReturnValue() - turtle.getUserFriendlyXPos();
        double yDiff = getChildren().get(1).getReturnValue() - turtle.getUserFriendlyYPos();
        double degrees = Math.toDegrees(Math.atan2(xDiff, yDiff));
        setReturnValue(Math.abs(degrees - oldAngle));
        turtle.turnTo(degrees);
    }
}
