package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class PowerCommand extends BasicCommand {

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
