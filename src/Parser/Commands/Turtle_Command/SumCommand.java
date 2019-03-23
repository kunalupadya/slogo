package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command returns sum of the values of expr1 param and expr2 param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SumCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public SumCommand(){
        setNumParameters(2);
        isOutputCommand = true;
        unlimitedParameters = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(getChildren().get(0).getReturnValue() + getChildren().get(1).getReturnValue());
    }

}
