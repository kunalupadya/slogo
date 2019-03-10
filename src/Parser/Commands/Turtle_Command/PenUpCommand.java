package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class PenUpCommand extends Command {

    public PenUpCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        if (turtle.getIsTurtleActive()) {
            turtle.setPenUp(true);
        }
        setReturnValue(0);
    }

    @Override
    public Command copy() {
        return new PenUpCommand();
    }
}
