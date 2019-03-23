package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;

/**
 * Command represents the end of Group.
 *
 * @author kunalupadya
 */
public class GroupEndCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public GroupEndCommand(){
        setNumParameters(0);
        isOutputCommand = false;
        setIsEvaluated(true);
    }

    @Override
    protected void performAction(BackendController backendController) { }

}
