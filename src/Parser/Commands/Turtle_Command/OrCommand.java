package Parser.Commands.Turtle_Command;

import Main.BackendController;

public class OrCommand extends BooleanCommand {

    public OrCommand() {
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController) {
        returnValue = returnValue(myChildrenList.get(0).getReturnValue() != 0 || myChildrenList.get(1).getReturnValue() != 0);
    }
}
