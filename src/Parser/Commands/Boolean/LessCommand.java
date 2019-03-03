package Parser.Commands.Boolean;

import Main.BackendController;

public class LessCommand extends BooleanCommand {

    public LessCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() < myChildrenList.get(1).getReturnValue());
    }

}
