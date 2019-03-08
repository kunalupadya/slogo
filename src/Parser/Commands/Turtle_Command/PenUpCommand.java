package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class PenUpCommand extends TurtleCommand {

    public PenUpCommand(){
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setPenUp(true);
        returnValue = 0;
    }

    @Override
    public Command copy() {
        return new PenUpCommand();
    }
}
