package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class PiCommand extends BasicCommand {

    public PiCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.PI);
    }

    @Override
    public Command copy() {
        return new PiCommand();
    }
}
