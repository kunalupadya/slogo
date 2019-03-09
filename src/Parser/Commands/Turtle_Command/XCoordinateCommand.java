package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class XCoordinateCommand extends TurtleCommand {

    public XCoordinateCommand(){
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue =turtle.getxPos();
    }

    @Override
    public Command copy() {
        return new XCoordinateCommand();
    }
}
