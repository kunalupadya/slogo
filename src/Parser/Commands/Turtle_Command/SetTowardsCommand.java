package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 */
public class SetTowardsCommand extends TurtleCommand {

    public SetTowardsCommand(){
        isEvaluated = false;
        numParameters = 2;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        double oldAngle = turtle.getMyAngle();
        double xdiff = getChildren().get(0).getReturnValue() - turtle.getxPos();
        double ydiff = getChildren().get(1).getReturnValue() - turtle.getyPos();
        double degrees = Math.toDegrees(Math.atan2(xdiff, ydiff));
        turtle.turnTo(degrees);
        returnValue = Math.abs(degrees-oldAngle);
    }

    @Override
    public Command copy() {
        return new SetTowardsCommand();
    }
}
