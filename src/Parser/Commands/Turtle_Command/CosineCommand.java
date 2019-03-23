package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class CosineCommand extends BasicCommand {

    public CosineCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.cos(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

}
