package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import javafx.scene.Group;

public class GroupStartCommand extends Command {

    public static final int COMMAND_INDEX = 0;

    public GroupStartCommand(){
        isConstant = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
    }

    @Override
    protected void performAction(BackendController backendController) {
        returnValue = myChildrenList.get(COMMAND_INDEX).getReturnValue();
    }

    @Override
    public Command copy() {
        return new GroupStartCommand();
    }
}