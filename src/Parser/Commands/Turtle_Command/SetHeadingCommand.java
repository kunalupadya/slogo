package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 */
public class SetHeadingCommand extends TurtleCommand{

    public SetHeadingCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        double oldAngle = turtle.getMyAngle();
        turtle.turnTo(getChildren().get(0).getReturnValue());
        setReturnValue(Math.abs(getChildren().get(0).getReturnValue()-oldAngle));
    }

    @Override
    public Command copy() {
        return new SetHeadingCommand();
    }
}
