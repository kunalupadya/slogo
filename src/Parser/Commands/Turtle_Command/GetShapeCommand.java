package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class GetShapeCommand extends TurtleCommand {

    public GetShapeCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getMyShape());
    }

    @Override
    public Command copy() {
        return new GetShapeCommand();
    }
}
