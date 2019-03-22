package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class MinusCommand extends BasicCommand {

    public MinusCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(-getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new MinusCommand();
    }
}
