package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 */
public class SetHeadingCommand extends TurtleCommand {

    public SetHeadingCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        double oldAngle = turtle.getMyAngle();
        setReturnValue(Math.abs(getChildren().get(0).getReturnValue()-oldAngle));
        turtle.turnTo(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SetHeadingCommand();
    }
}
