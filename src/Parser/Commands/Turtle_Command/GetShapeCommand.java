package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class GetShapeCommand extends TurtleCommand {

    public GetShapeCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        setReturnValue(turtle.getMyShape());
    }

    @Override
    public Command copy() {
        return new GetShapeCommand();
    }
}
