package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class DoTimesCommand extends ControlCommand {

    private final int VAR_LIMIT_INDEX = 0;
    private final int COMMANDS_INDEX = 1;
    private ListStartCommand commandListOrig;
    private Variable loopVar;

    public DoTimesCommand() {
        super();
        isEvaluated = false;
        numParameters = 2;
    }

    @Override
    protected void performAction(BackendController backendController) {
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

    private void updateLoopVar(BackendController backendController) {
        var makeLoopVar = new MakeVariableCommand();
        makeLoopVar.addChildren(loopVar);
        makeLoopVar.addChildren(new ConstantCommand((double) currCount));
        makeLoopVar.execute(backendController);
    }

    @Override
    public void setInitialExpressions() {
        ListStartCommand loopParam = (ListStartCommand) myChildrenList.get(VAR_LIMIT_INDEX);
        initialExpressions.add(loopParam.getChildren().get(1));
    }

    @Override
    public void setUpLoop() {
        ListStartCommand loopParam = (ListStartCommand) myChildrenList.get(VAR_LIMIT_INDEX);
        loopVar = (Variable) loopParam.getChildren().get(0);
        limit = (int) initialExpressions.get(0).getReturnValue();
        commandListOrig = (ListStartCommand) myChildrenList.get(COMMANDS_INDEX);
    }

    @Override
    public Command copy() {
        return new DoTimesCommand();
    }
}
