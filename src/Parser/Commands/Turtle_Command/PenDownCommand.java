package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class PenDownCommand extends TurtleCommand {

    public PenDownCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController) {
        getTurtle().getMyPen().setPenUp(false);
        returnValue = 1;

    }
}
