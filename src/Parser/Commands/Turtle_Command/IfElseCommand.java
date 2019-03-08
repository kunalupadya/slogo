package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class IfElseCommand extends ControlCommand {

    private final int trueCommandList = 1;
    private final int falseCommandList = 2;

    public IfElseCommand() {
        super();
        setNumParameters(3);
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (initialExpressions.get(0).getReturnValue() != 0) {
            setListToRun((ListStartCommand) getChildren().get(trueCommandList));
        } else {
            setListToRun((ListStartCommand) getChildren().get(falseCommandList));
        }
        runAgain = false;
    }

    @Override
    public void setInitialExpressions() {
        initialExpressions.add(getChildren().get(0));
    }

    @Override
    public void setUpLoop() { }

    @Override
    public Command copy() {
        return new IfElseCommand();
    }
}
