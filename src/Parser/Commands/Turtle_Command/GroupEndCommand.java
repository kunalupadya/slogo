package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class GroupEndCommand extends Command {
    public GroupEndCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {

    }

    @Override
    public Command copy() {
        return new GroupEndCommand();
    }
}
