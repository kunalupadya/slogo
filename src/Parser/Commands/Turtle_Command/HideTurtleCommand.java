package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class HideTurtleCommand extends TurtleCommand {

    public HideTurtleCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController) {
        getTurtle().setTurtleVisibility(false);
        returnValue = 0;

    }
}
