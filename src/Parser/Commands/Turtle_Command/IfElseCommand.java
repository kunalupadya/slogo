package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.ExecutionException;

/**
 * If expr is not 0, Command runs the trueCommands given in the first list, otherwise runs the falseCommands given in
 * the second list.
 *
 * @author Dhanush Madabusi
 */

public class IfElseCommand extends ControlCommand {

    private static final int EXPRESSION_INDEX = 0;
    private static final int TRUE_COMMANDS = 1;
    private static final int FALSE_COMMANDS = 2;

    /**
     * Command Constructor
     */
    public IfElseCommand() {
        super();
        setNumParameters(3);
    }

    /**
     * Determines which expressions to evaluate prior to evaluating main command.
     */
    @Override
    public void setInitialExpressions() {
        initialExpressions.add(getChildren().get(EXPRESSION_INDEX));
    }

    /**
     * Sets up any instance variable prior to evaluating any loop commands.
     *
     * @throws ExecutionException if an error occurs while executing
     */
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
}
