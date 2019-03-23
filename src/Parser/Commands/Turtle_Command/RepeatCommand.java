package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class RepeatCommand extends ControlCommand {

    private static final int EXPRESSION_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;
    private ListStartCommand commandListOrig;

    public RepeatCommand() {
        super();
        setNumParameters(2);
    }

    private void setRepCount(BackendController backendController) throws SLogoException{
        var makeRepCountVar = new MakeVariableCommand();
        makeRepCountVar.addChildren(new Variable("repcount"));
        makeRepCountVar.addChildren(new ConstantCommand((double) currCount));
        makeRepCountVar.execute(backendController);
    }

    @Override
    public void setInitialExpressions() {
        initialExpressions.add(getChildren().get(EXPRESSION_INDEX));
    }

    @Override
    public void setUpLoop() throws ExecutionException {
        limit = (int) initialExpressions.get(EXPRESSION_INDEX).getReturnValue();
        if (limit < 0) {
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        commandListOrig = (ListStartCommand) getChildren().get(COMMANDS_INDEX);
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        if (currCount <= limit) {
            setRepCount(backendController);
            setListToRun(copyList(commandListOrig));
            currCount++;
            runAgain = true;
        }
        else{
            runAgain = false;
        }
    }

}
