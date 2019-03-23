package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command returns sine of degrees param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SineCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public SineCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.sin(Math.toRadians(getChildren().get(0).getReturnValue())));
    }
}
