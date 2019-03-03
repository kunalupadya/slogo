package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class TanCommand extends Command {

    public TanCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.tan(myChildrenList.get(0).getReturnValue());
    }

}
