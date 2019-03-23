package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command returns remainder on dividing the values of expr1 param by expr2 param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class RemainderCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public RemainderCommand(){
        setNumParameters(2);
        isOutputCommand = true;
        unlimitedParameters = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(getChildren().get(0).getReturnValue() % getChildren().get(1).getReturnValue());
    }

}
