package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class PowerCommand extends Command {

    public PowerCommand(){
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.pow(myChildrenList.get(0).getReturnValue(),myChildrenList.get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new PowerCommand();
    }
}
