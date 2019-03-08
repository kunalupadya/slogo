package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class RepeatCommand extends ControlCommand {

    private ListStartCommand commandListOrig;

    public RepeatCommand() {
        super();
        isEvaluated = false;
        numParameters = 2;
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
        initialExpressions.add(myChildrenList.get(0));
    }

    @Override
    public void setUpLoop() {
        limit = (int) initialExpressions.get(0).getReturnValue();
        commandListOrig = (ListStartCommand) myChildrenList.get(1);
    }

    @Override
    public Command copy() {
        return new RepeatCommand();
    }
}
