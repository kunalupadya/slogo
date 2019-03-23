package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command returns base param raised to the power of the exponent param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class PowerCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public PowerCommand(){
        setNumParameters(2);
        isOutputCommand = true;
        unlimitedParameters = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.pow(getChildren().get(0).getReturnValue(),getChildren().get(1).getReturnValue()));
    }
}
