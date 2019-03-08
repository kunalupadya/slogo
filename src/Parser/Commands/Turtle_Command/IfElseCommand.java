package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class IfElseCommand extends ControlCommand {

    private final int trueCommandList = 1;
    private final int falseCommandList = 2;

    public IfElseCommand() {
        super();
        isConstant = false;
        numParameters = 3;
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (initialExpressions.get(0).getReturnValue() != 0) {
            setListToRun((ListStartCommand) myChildrenList.get(trueCommandList));
        } else {
            setListToRun((ListStartCommand) myChildrenList.get(falseCommandList));
        }
        runAgain = false;
    }

    @Override
    public void setInitialExpressions() {
        initialExpressions.add(myChildrenList.get(0));
    }

    @Override
    public void setUpLoop() { }

    @Override
    public Command copy() {
        return new IfElseCommand();
    }
}
