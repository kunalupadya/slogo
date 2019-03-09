package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class RepeatCommand extends ControlCommand {


    private final int EXPRESSION_INDEX = 0;
    private final int COMMANDS_INDEX = 1;
    private ListStartCommand commandListOrig;

    public RepeatCommand() {
        super();
        setIsEvaluated(false);
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
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

    private void setRepCount(BackendController backendController) {
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
    public void setUpLoop() {
        limit = (int) initialExpressions.get(EXPRESSION_INDEX).getReturnValue();
        commandListOrig = (ListStartCommand) getChildren().get(COMMANDS_INDEX);
    }

    @Override
    public Command copy() {
        return new RepeatCommand();
    }
}
