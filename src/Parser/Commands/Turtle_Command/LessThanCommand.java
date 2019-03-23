package Parser.Commands.Turtle_Command;

import Parser.BackendController;

/**
 * Command returns 1 if the value of expr1 param is strictly less than the value of expr2 param, otherwise 0.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class LessThanCommand extends BooleanCommand {

    /**
     * Command Constructor
     */
    public LessThanCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() < getChildren().get(1).getReturnValue()));
    }

}
