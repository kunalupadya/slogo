package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class DifferenceCommand extends BasicCommand {

    public DifferenceCommand(){
        setNumParameters(2);
        isOutputCommand = true;
        unlimitedParameters = true;
    }

    @Override
    protected void performAction(BackendController backendController) {

        setReturnValue(getChildren().get(0).getReturnValue() - getChildren().get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new DifferenceCommand();
    }
}
