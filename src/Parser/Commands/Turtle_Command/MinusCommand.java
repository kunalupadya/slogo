package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class MinusCommand extends Command {

    public MinusCommand(){
        isOutputCommand = true;
        isEvaluated = false;
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
