package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class PenUpCommand extends TurtleCommand {

    public PenUpCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.getMyPen().setPenUp(true);
        returnValue = 0;
    }
}
