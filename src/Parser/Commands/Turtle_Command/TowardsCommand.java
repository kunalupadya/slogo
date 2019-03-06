package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class TowardsCommand extends TurtleCommand {

    public TowardsCommand(){
        isConstant = false;
        numParameters = 2;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        double xdiff = getChildren().get(0).getReturnValue() - turtle.getxPos();
        double ydiff = getChildren().get(1).getReturnValue() - turtle.getyPos();
        double degrees = Math.toDegrees(Math.atan2(ydiff, xdiff)) - turtle.getMyAngle();
        turtle.turn(degrees);
        returnValue = degrees;
    }

    @Override
    public Command copy() {
        return new TowardsCommand();
    }
}
