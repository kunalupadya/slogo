package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class XCoordinateCommand extends Command {

    public XCoordinateCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getxPos());
    }

    @Override
    public Command copy() {
        return new XCoordinateCommand();
    }
}
