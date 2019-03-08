package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class IfElseCommand extends ControlCommand {

    private final int TRUE_COMMANDS = 1;
    private final int FALSE_COMMANDS = 2;

    public IfElseCommand() {
        super();
        isEvaluated = false;
        numParameters = 3;
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (initialExpressions.get(0).getReturnValue() != 0) {
            setListToRun((ListStartCommand) myChildrenList.get(TRUE_COMMANDS));
        } else {
            setListToRun((ListStartCommand) myChildrenList.get(FALSE_COMMANDS));
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
