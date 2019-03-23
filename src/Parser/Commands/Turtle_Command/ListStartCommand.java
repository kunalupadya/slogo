package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command represents start of a List.
 *
 * @author kunalupadya
 */
public class ListStartCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public ListStartCommand(){
        setNumParameters((int) Double.POSITIVE_INFINITY);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(getChildren().size() - 1);
    }

}
