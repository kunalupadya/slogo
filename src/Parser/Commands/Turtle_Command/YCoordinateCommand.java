package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class YCoordinateCommand extends TurtleCommand {

    public YCoordinateCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        setReturnValue(turtle.getyPos());
    }

    @Override
    public Command copy() {
        return new YCoordinateCommand();
    }
}
