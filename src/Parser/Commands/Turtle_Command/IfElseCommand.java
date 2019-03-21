package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.ExecutionException;

public class IfElseCommand extends ControlCommand {

    private static final int EXPRESSION_INDEX = 0;
    private static final int TRUE_COMMANDS = 1;
    private static final int FALSE_COMMANDS = 2;

    public IfElseCommand() {
        super();
        setNumParameters(3);
    }

    @Override
    public void setInitialExpressions() {
        initialExpressions.add(getChildren().get(EXPRESSION_INDEX));
    }

    @Override
    public void setUpLoop() throws ExecutionException { }

    @Override
    protected void performAction(BackendController backendController) {
        if (initialExpressions.get(EXPRESSION_INDEX).getReturnValue() != 0) {
            setListToRun((ListStartCommand) getChildren().get(TRUE_COMMANDS));
        } else {
            setListToRun((ListStartCommand) getChildren().get(FALSE_COMMANDS));
        }
        runAgain = false;
    }

    @Override
    public Command copy() {
        return new IfElseCommand();
    }
}
