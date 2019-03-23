package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class ArcTangentCommand extends BasicCommand {

    public ArcTangentCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    public void performAction(BackendController backendController) {
        setReturnValue(Math.atan(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

}
