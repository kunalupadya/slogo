package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class QuotientCommand extends Command {

    public QuotientCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue = myChildrenList.get(0).getReturnValue() / myChildrenList.get(1).getReturnValue();
    }

}
