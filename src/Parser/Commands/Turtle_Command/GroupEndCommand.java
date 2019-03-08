package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class GroupEndCommand extends Command {
    public GroupEndCommand(){
        setNumParameters(0);
    }

    @Override
    protected void performAction(BackendController backendController) {
    }

    @Override
    public Command copy() {
        return new GroupEndCommand();
    }
}
