package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class RightCommand extends TurtleCommand {

    public RightCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.turn(getChildren().get(0).getReturnValue());
        setReturnValue(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new RightCommand();
    }
}
