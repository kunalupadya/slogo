package Parser.Commands.Turtle_Command;

import Parser.BackendController;

/**
 * Command returns 1 if test1 param or test2 param are non-zero, otherwise 0.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class OrCommand extends BooleanCommand {

    /**
     * Command Constructor
     */
    public OrCommand() {
        super();
        setNumParameters(2);
        unlimitedParameters = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() != 0 ||
                getChildren().get(1).getReturnValue() != 0));
    }
}
