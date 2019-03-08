package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class ForCommand extends ControlCommand {

    private ListStartCommand commandListOrig = (ListStartCommand) myChildrenList.get(1);

    public DoTimesCommand() {
        super();
        isConstant = false;
        numParameters = 2;
    }

    @Override
    protected void performAction(BackendController backendController) {
        updateLoopVar(backendController);
        if (currCount < limit) {
            setListToRun(copyList(commandListOrig));
            currCount++;
            runAgain = true;
        }
        else{
            runAgain = false;
        }

    }

    private void updateLoopVar(BackendController backendController) {
        ListStartCommand loopParam = (ListStartCommand) myChildrenList.get(0);
        Variable loopVar = (Variable) loopParam.getChildren().get(0);
        limit = (int) loopParam.getChildren().get(1).getReturnValue();
        var makeLoopVar = new MakeVariableCommand();
        makeLoopVar.addChildren(loopVar);
        makeLoopVar.addChildren(new ConstantCommand((double) currCount));
        makeLoopVar.execute(backendController);
    }

    @Override
    public void setInitialExpression() { }

    @Override
    public Command copy() {
        return new ForCommand();
    }
}
