package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class XCoordinateCommand extends TurtleCommand {

    public XCoordinateCommand(){
<<<<<<< HEAD
        setNumParameters(0);
=======
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 0;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        setReturnValue(turtle.getxPos());
    }

    @Override
    public Command copy() {
        return new XCoordinateCommand();
    }
}
