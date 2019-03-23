package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command reports the number Pi.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class PiCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public PiCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.PI);
    }

}
