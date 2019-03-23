package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command returns natural log of expr param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class NaturalLogCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public NaturalLogCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.log(getChildren().get(0).getReturnValue()));
    }

}
