package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class XCoordinateCommand extends TurtleCommand {

    public XCoordinateCommand(){
        setNumParameters(0);
        isOutputCommand = true;
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
