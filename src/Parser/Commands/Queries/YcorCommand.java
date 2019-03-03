package Parser.Commands.Queries;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class YcorCommand extends TurtleCommand {

    public YcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        getTurtle().getyPos();
    }

}
