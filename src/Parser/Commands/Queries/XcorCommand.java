package Parser.Commands.Queries;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class XcorCommand extends TurtleCommand {

    public XcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        getTurtle().getxPos();
    }
}
