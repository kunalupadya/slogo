package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ShowTurtleCommand extends TurtleCommand {

    public ShowTurtleCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController) {
        getTurtle().setTurtleVisibility(true);
        returnValue = 1;

    }
}