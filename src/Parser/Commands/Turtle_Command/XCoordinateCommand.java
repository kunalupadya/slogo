package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class XCoordinateCommand extends TurtleCommand {

    public XCoordinateCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
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
