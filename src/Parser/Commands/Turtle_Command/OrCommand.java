package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class OrCommand extends BooleanCommand {

    public OrCommand() {
        isEvaluated = false;
        numParameters = 2;
    }

    public void performAction(BackendController backendController) {
        returnValue = returnValue(myChildrenList.get(0).getReturnValue() != 0 || myChildrenList.get(1).getReturnValue() != 0);
    }

    @Override
    public Command copy() {
        return new OrCommand();
    }
}
