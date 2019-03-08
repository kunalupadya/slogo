package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class YCoordinateCommand extends TurtleCommand {

    public YCoordinateCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue =turtle.getyPos();
    }

    @Override
    public Command copy() {
        return new YCoordinateCommand();
    }
}
