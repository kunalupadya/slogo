package Parser.Commands.Boolean;

import Main.BackendController;

public class NotEqualCommand extends BooleanCommand{

    public NotEqualCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() !=0);
    }

}
