package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Commands return cosine of degrees param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class CosineCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public CosineCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.cos(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

}
