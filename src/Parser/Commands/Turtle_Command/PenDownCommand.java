package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class PenDownCommand extends TurtleCommand {

    public PenDownCommand(){
        isEvaluated = false;
        numParameters = 0;
    }

//    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setPenUp(false);
        returnValue = 1;
    }

    @Override
    public Command copy() {
        return new PenDownCommand();
    }
}
