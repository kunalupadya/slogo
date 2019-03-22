package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class YCoordinateCommand extends TurtleCommand {

    public YCoordinateCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getUserFriendlyYPos());
    }

    @Override
    public Command copy() {
        return new YCoordinateCommand();
    }
}
