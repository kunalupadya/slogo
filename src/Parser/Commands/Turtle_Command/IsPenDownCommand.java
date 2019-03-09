package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class IsPenDownCommand extends TurtleCommand {

    private static final int PEN_DOWN = 1;
    private static final int PEN_UP = 0;

    public IsPenDownCommand(){
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = turtle.getMyPen().getPenUp() ? PEN_UP : PEN_DOWN;
    }

    @Override
    public Command copy() {
        return new IsShowingCommand();
    }
}
