package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class MinusCommand extends Command {

    public MinusCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue = -myChildrenList.get(0).getReturnValue();
    }

    @Override
    public Command copy() {
        return new MinusCommand();
    }
}
