package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class GroupEndCommand extends Command {
    public GroupEndCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController) {
    }

    @Override
    public Command copy() {
        return new GroupEndCommand();
    }
}
