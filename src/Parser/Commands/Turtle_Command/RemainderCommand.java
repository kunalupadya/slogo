package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class RemainderCommand extends Command {

    public RemainderCommand(){
        isEvaluated = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue = myChildrenList.get(0).getReturnValue() % myChildrenList.get(1).getReturnValue();
    }

    @Override
    public Command copy() {
        return new RemainderCommand();
    }
}
