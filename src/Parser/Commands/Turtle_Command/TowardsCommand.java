package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class TowardsCommand extends TurtleCommand {

    public TowardsCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void execute(){
        double xdiff = getChildren().get(0).getReturnValue() - getTurtle().getxPos();
        double ydiff = getChildren().get(1).getReturnValue() - getTurtle().getyPos();
        double degrees = Math.toDegrees(Math.atan2(ydiff, xdiff)) - getTurtle().getMyAngle();
        getTurtle().turn(degrees);
        returnValue = degrees;
    }

}
