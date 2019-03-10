package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class PenDownCommand extends Command {

    public PenDownCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        if (turtle.getIsTurtleActive()) {
            turtle.setPenUp(false);
        }
        setReturnValue(1);
    }

    @Override
    public Command copy() {
        return new PenDownCommand();
    }
}
