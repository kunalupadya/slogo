package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class NaturalLogCommand extends BasicCommand {

    public NaturalLogCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.log(getChildren().get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new NaturalLogCommand();
    }
}
