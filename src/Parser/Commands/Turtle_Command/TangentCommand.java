package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command returns tangent of degrees param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class TangentCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public TangentCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.tan(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

}
