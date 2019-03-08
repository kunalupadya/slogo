package Parser.Commands.Turtle_Command;


import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class EqualCommand extends BooleanCommand{

    public EqualCommand(){
        isEvaluated = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() ==  myChildrenList.get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new EqualCommand();
    }
}
