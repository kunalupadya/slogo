package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

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
            setListToRun(copyList(commandListOrig));
            currCount++;
            runAgain = true;
        }
        else{
            runAgain = false;
        }

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
