package Parser.Commands.Math;

import Main.BackendController;
import Parser.Commands.Command;

public class RemainderCommand extends Command {

    public RemainderCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue = myChildrenList.get(0).getReturnValue() % myChildrenList.get(1).getReturnValue();
    }

}
