package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class IfCommand extends ControlCommand {

    public IfCommand() {
        isConstant = false;
        numParameters = 2;
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (initialExpression.getReturnValue() != 0) {
            setListToRun((ListStartCommand) myChildrenList.get(1));
        } else {
            setReturnValue(0);
        }
    }

    @Override
    public void setInitialExpression() {
        initialExpression = myChildrenList.get(0);
    }

    @Override
    public Command copy() {
        return new IfCommand();
    }
}
