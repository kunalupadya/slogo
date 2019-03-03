package Parser.Commands.Math;

import Main.BackendController;
import Parser.Commands.Command;

public class SumCommand extends Command {

    public SumCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue =  myChildrenList.get(0).getReturnValue() + myChildrenList.get(1).getReturnValue();
    }

}
