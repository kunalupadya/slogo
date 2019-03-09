package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class CosineCommand extends Command {

    public CosineCommand(){
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.cos(Math.toRadians(myChildrenList.get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new CosineCommand();
    }
}
