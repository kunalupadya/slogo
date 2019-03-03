package Parser.Commands.Boolean;

import Main.BackendController;

public class GreaterCommand extends BooleanCommand {

    public GreaterCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() > myChildrenList.get(1).getReturnValue());
    }

}
