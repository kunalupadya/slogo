package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command represents end of a List.
 *
 * @author kunalupadya
 */
public class ListEndCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public ListEndCommand(){
        setNumParameters(0);
        isOutputCommand = false;
        setIsEvaluated(true);
    }

    @Override
    protected void performAction(BackendController backendController) {

    }

}
