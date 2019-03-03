package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ShowingCommand extends TurtleCommand {

    public static final int SHOWING = 1;
    public static final int HIDDEN = 0;

    public ShowingCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = turtle.getTurtleVisibility() ? SHOWING : HIDDEN;
    }
}
