package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class RightCommand extends TurtleCommand {

    public RightCommand(){
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.turn(getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }

    @Override
    public Command copy() {
        return new RightCommand();
    }
}
