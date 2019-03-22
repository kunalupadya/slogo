package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ListStartCommand;
import Parser.ExecutionException;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class IfCommand extends ControlCommand{

    private static final int EXPRESSION_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;


    public IfCommand(){
        super();
        setNumParameters(2);
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
            setListToRun((ListStartCommand) getChildren().get(COMMANDS_INDEX));
        }
        runAgain = false;
    }

    @Override
    public Command copy() {
        return new IfCommand();
    }
}