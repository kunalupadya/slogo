package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class TurtlesCommand extends Command {

    public TurtlesCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(backendController.getMyTurtles().size());
    }

    @Override
    public Command copy() {
        return new TurtlesCommand();
    }
}