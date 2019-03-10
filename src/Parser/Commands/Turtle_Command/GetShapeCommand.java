package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class GetShapeCommand extends Command {

    public GetShapeCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = true;
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
