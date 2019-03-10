package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class PiCommand extends Command {

    public PiCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(Math.PI);
    }

    @Override
    public Command copy() {
        return new PiCommand();
    }
}
