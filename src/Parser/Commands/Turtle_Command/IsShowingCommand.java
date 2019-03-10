package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class IsShowingCommand extends Command {

    private static final int SHOWING = 1;
    private static final int HIDDEN = 0;

    public IsShowingCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.isTurtleVisible() ? SHOWING : HIDDEN);
    }

    @Override
    public Command copy() {
        return new IsShowingCommand();
    }
}
