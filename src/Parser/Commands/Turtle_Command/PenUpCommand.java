package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class PenUpCommand extends TurtleCommand {

    public PenUpCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController) {
        getTurtle().getMyPen().setPenUp(true);
        returnValue = 0;

    }
}
