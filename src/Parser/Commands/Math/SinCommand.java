package Parser.Commands.Math;

import Main.BackendController;
import Parser.Commands.Command;

public class SinCommand extends Command {

    public SinCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.cos(myChildrenList.get(0).getReturnValue());
    }

}
