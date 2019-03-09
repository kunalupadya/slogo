package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class NotCommand extends BooleanCommand{

    public NotCommand(){
        super();
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue = returnValue(myChildrenList.get(0).getReturnValue() == 0);
    }

    @Override
    public Command copy() {
        return new NotCommand();
    }
}
