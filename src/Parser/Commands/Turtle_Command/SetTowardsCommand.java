package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class SetTowardsCommand extends Command {

    public SetTowardsCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        double oldAngle = turtle.getMyAngle();
        double xdiff = getChildren().get(0).getReturnValue() - turtle.getxPos();
        double ydiff = getChildren().get(1).getReturnValue() - turtle.getyPos();
        double degrees = Math.toDegrees(Math.atan2(xdiff, ydiff));
        setReturnValue(Math.abs(degrees-oldAngle));
        if (turtle.getIsTurtleActive()) {
            turtle.turnTo(degrees);
        }
    }

    @Override
    public Command copy() {
        return new SetTowardsCommand();
    }
}
