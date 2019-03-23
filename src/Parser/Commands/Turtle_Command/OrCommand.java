package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class OrCommand extends BooleanCommand {

    public OrCommand() {
        super();
        setNumParameters(2);
        unlimitedParameters = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() != 0 || getChildren().get(1).getReturnValue() != 0));
    }
}
