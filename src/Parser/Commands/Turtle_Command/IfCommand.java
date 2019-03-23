package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.ExecutionException;

/**
 * If expr param is not 0, Command runs the command(s) given in the list.
 *
 * @author Dhanush Madabusi
 */

public class IfCommand extends ControlCommand{

    private static final int EXPRESSION_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;

    /**
     * Command Constructor
     */
    public IfCommand(){
        super();
        setNumParameters(2);
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
            setListToRun((ListStartCommand) getChildren().get(COMMANDS_INDEX));
        }
        runAgain = false;
    }
}