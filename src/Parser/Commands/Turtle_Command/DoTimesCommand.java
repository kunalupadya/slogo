package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * Command runs command(s) for each value specified in the range, i.e., from (1 - limit) inclusive.
 *
 * @author Dhanush Madabusi
 */

public class DoTimesCommand extends ControlCommand {

    private static final int VAR_LIMIT_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;
    private ListStartCommand commandListOrig;
    private Variable loopVar;

    /**
     * Command Constructor
     */
    public DoTimesCommand() {
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        updateLoopVar(backendController);
        if (currCount <= limit) {
            setListToRun(copyList(commandListOrig));
            currCount++;
            runAgain = true;
        }
        else{
            runAgain = false;
        }
    }

    private void updateLoopVar(BackendController backendController) throws SLogoException{
        var makeLoopVar = new MakeVariableCommand();
        makeLoopVar.addChildren(loopVar);
        makeLoopVar.addChildren(new ConstantCommand((double) currCount));
        makeLoopVar.execute(backendController);
    }

    /**
     * Determines which expressions to evaluate prior to evaluating main command.
     */
    @Override
    public void setInitialExpressions() {
        ListStartCommand loopParam = (ListStartCommand) getChildren().get(VAR_LIMIT_INDEX);
        initialExpressions.add(loopParam.getChildren().get(1));
    }

    /**
     * Sets up any instance variable prior to evaluating any loop commands.
     *
     * @throws ExecutionException if an error occurs while executing
     */
    @Override
    public void setUpLoop() throws ExecutionException {
        ListStartCommand loopParam = (ListStartCommand) getChildren().get(VAR_LIMIT_INDEX);
        loopVar = (Variable) loopParam.getChildren().get(0);
        limit = (int) initialExpressions.get(0).getReturnValue();
        if (limit < 0) {
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        commandListOrig = (ListStartCommand) getChildren().get(COMMANDS_INDEX);
    }

}
