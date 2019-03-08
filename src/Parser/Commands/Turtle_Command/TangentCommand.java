package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class TangentCommand extends Command {

    public TangentCommand(){
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.tan(Math.toRadians(myChildrenList.get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new TangentCommand();
    }
}
