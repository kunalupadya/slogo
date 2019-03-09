package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class PenDownCommand extends TurtleCommand {

    public PenDownCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

//    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setPenUp(false);
        setReturnValue(1);
    }

    @Override
    public Command copy() {
        return new PenDownCommand();
    }
}
