package Parser.Commands.Turtle_Command;

import Parser.BackendController;

/**
 * Command returns 1 if the value of expr1 param and the value of expr2 param are not equal, otherwise 0.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class NotEqualCommand extends BooleanCommand{

    /**
     * Command Constructor
     */
    public NotEqualCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() != getChildren().get(1).getReturnValue()));
    }

}
