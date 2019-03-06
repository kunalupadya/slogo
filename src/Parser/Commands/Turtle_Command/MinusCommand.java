package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class MinusCommand extends Command {

    public MinusCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue = myChildrenList.get(0).getReturnValue() - myChildrenList.get(1).getReturnValue();
    }

    @Override
    public Command copy() {
        return new MinusCommand();
    }
}
