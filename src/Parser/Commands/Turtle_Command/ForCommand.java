package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * Command runs command(s) for each value specified in the range, i.e., from (start - end), going by increment.
 *
 * @author Dhanush Madabusi
 */

public class ForCommand extends ControlCommand {

    private static final int VAR_RANGE_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;
    private ListStartCommand commandListOrig;
    private int increment;
    private Variable loopVar;

    /**
     * Command Constructor
     */
    public ForCommand() {
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        if (currCount <= limit) {
            updateLoopVar(backendController);
            setListToRun(copyList(commandListOrig));
            currCount += increment;
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
        ListStartCommand loopParam = (ListStartCommand) getChildren().get(VAR_RANGE_INDEX);
        initialExpressions.add(loopParam.getChildren().get(1));
        initialExpressions.add(loopParam.getChildren().get(2));
        initialExpressions.add(loopParam.getChildren().get(3));
    }

    /**
     * Sets up any instance variable prior to evaluating any loop commands.
     *
     * @throws ExecutionException if an error occurs while executing
     */
    @Override
    public void setUpLoop() throws ExecutionException {
        ListStartCommand loopParam = (ListStartCommand) getChildren().get(0);
        loopVar = (Variable) loopParam.getChildren().get(0);
        currCount = (int) initialExpressions.get(0).getReturnValue();
        limit = (int) initialExpressions.get(1).getReturnValue();
        increment = (int) initialExpressions.get(2).getReturnValue();
        if ((currCount < limit && increment < 0) || (currCount > limit && increment > 0)){
                String currCommandClass = this.getClass().toString();
                String prefix = "class Parser.Commands.Turtle_Command.";
                String command = currCommandClass.substring(prefix.length());
                throw new ExecutionException(command + " will not terminate with current parameters");
        }
        commandListOrig = (ListStartCommand) getChildren().get(COMMANDS_INDEX);
    }

}
