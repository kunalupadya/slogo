package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class NotCommand extends BooleanCommand{

    public NotCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() == 0));
    }

}
