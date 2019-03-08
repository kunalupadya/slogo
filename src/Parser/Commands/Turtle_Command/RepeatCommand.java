package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class RepeatCommand extends ControlCommand {

    private ListStartCommand commandListOrig = (ListStartCommand) myChildrenList.get(1);

    public RepeatCommand() {
        super();
        isConstant = false;
        numParameters = 2;
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (currCount < limit) {
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
    public void setInitialExpression() {
        initialExpression = myChildrenList.get(0);
    }

    @Override
    public Command copy() {
        return new RepeatCommand();
    }
}
