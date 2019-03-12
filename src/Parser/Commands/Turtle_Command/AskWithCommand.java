package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class AskWithCommand extends Command {

    public AskWithCommand(){
        isOutputCommand = false;
        setNumParameters(2);
    }

    @Override
    protected void turtleAction(Turtle turtle) {

    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {

    }

    @Override
    public Command copy() {
        return new AskWithCommand();
    }
}
