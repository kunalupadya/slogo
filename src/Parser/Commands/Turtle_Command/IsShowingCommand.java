package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class IsShowingCommand extends TurtleCommand {

    private static final int SHOWING = 1;
    private static final int HIDDEN = 0;

    public IsShowingCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        setReturnValue(turtle.isTurtleVisible() ? SHOWING : HIDDEN);
    }

    @Override
    public Command copy() {
        return new IsShowingCommand();
    }
}
