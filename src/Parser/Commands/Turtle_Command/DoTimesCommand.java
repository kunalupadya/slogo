package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class DoTimesCommand extends ControlCommand {

    private ListStartCommand commandListOrig = (ListStartCommand) myChildrenList.get(1);
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
        ListStartCommand loopParam = (ListStartCommand) myChildrenList.get(0);
        initialExpressions.add(loopParam.getChildren().get(1));
    }

    @Override
    public void setUpLoop() {
        ListStartCommand loopParam = (ListStartCommand) myChildrenList.get(0);
        loopVar = (Variable) loopParam.getChildren().get(0);
        limit = (int) initialExpressions.get(0).getReturnValue();
    }

    @Override
    public Command copy() {
        return new DoTimesCommand();
    }
}
