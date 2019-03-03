package Parser.Commands.Turtle_Command;

import Main.BackendController;

public class NotCommand extends BooleanCommand{

    public NotCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() ==0);
    }

}
