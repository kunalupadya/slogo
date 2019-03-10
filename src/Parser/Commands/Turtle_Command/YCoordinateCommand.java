package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class YCoordinateCommand extends Command {

    public YCoordinateCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getyPos());
    }

    @Override
    public Command copy() {
        return new YCoordinateCommand();
    }
}
