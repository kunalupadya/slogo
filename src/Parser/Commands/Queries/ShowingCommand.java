package Parser.Commands.Queries;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ShowingCommand extends TurtleCommand {

    public ShowingCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        getTurtle().setTurtleVisibility(true);
    }
}
