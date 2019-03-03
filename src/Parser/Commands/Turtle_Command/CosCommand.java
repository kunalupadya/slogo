package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class CosCommand extends Command {

    public CosCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.cos(myChildrenList.get(0).getReturnValue());
    }

}
