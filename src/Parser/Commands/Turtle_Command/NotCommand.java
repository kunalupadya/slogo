package Parser.Commands.Turtle_Command;

import Parser.BackendController;

/**
 * Command returns 1 if test param is 0 and 0 if test param is non-zero.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class NotCommand extends BooleanCommand{

    /**
     * Command Constructor
     */
    public NotCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() == 0));
    }

}
