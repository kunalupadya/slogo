package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class NotEqualCommand extends BooleanCommand{

    public NotEqualCommand(){
        super();
        isEvaluated = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() !=myChildrenList.get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new NotEqualCommand();
    }
}
