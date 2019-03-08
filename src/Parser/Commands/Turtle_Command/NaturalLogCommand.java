package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class NaturalLogCommand extends Command {

    public NaturalLogCommand(){
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.log(myChildrenList.get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new NaturalLogCommand();
    }
}
