package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 */
public class SetTowardsCommand extends TurtleCommand {

    public SetTowardsCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        double oldAngle = turtle.getMyAngle();
        double xDiff = getChildren().get(0).getReturnValue() - turtle.getxPos();
        double yDiff = getChildren().get(1).getReturnValue() - turtle.getyPos();
        double degrees = Math.toDegrees(Math.atan2(xDiff, yDiff));
        setReturnValue(Math.abs(degrees - oldAngle));
        turtle.turnTo(degrees);
    }

    @Override
    public Command copy() {
        return new SetTowardsCommand();
    }
}
