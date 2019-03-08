package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ShapeCommand extends TurtleCommand {

    public ShapeCommand(){
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = turtle.getMyShape();
    }

    @Override
    public Command copy() {
        return new ShapeCommand();
    }
}
