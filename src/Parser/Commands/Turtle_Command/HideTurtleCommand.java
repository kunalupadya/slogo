package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class HideTurtleCommand extends Command {

    public HideTurtleCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        if (turtle.getIsTurtleActive()) {
            turtle.setTurtleVisibility(false);
        }
        setReturnValue(0);
    }

    @Override
    public Command copy() {
        return new HideTurtleCommand();
    }
}
