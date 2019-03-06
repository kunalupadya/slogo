package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class PenDownCommand extends TurtleCommand {

    public PenDownCommand(){
        isConstant = false;
        numParameters = 0;
    }

//    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.getMyPen().setPenUp(false);
        returnValue = 1;
    }

    @Override
    public Command copy() {
        return new PenDownCommand();
    }
}
