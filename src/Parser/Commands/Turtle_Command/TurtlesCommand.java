package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class TurtlesCommand extends TurtleCommand {

    public TurtlesCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        returnValue = getTurtleList().size();
    }
}
