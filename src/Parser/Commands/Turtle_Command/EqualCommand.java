package Parser.Commands.Turtle_Command;


import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class EqualCommand extends BooleanCommand{

    public EqualCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() == getChildren().get(1).getReturnValue()));

    }

}
