package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

public class ForCommand extends ControlCommand {

    private final int VAR_RANGE_INDEX = 0;
    private final int COMMANDS_INDEX = 1;
    private ListStartCommand commandListOrig;
    private int increment;
    private Variable loopVar;

    public ForCommand() {
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
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

    private void updateLoopVar(BackendController backendController) {
        var makeLoopVar = new MakeVariableCommand();
        makeLoopVar.addChildren(loopVar);
        makeLoopVar.addChildren(new ConstantCommand((double) currCount));
        makeLoopVar.execute(backendController);
    }

    @Override
    public void setInitialExpressions() {
        ListStartCommand loopParam = (ListStartCommand) getChildren().get(VAR_RANGE_INDEX);
        initialExpressions.add(loopParam.getChildren().get(1));
        initialExpressions.add(loopParam.getChildren().get(2));
        initialExpressions.add(loopParam.getChildren().get(3));
    }

    @Override
    public void setUpLoop() {
        ListStartCommand loopParam = (ListStartCommand) getChildren().get(0);
        loopVar = (Variable) loopParam.getChildren().get(0);
        currCount = (int) initialExpressions.get(0).getReturnValue();
        limit = (int) initialExpressions.get(1).getReturnValue();
        increment = (int) initialExpressions.get(2).getReturnValue();
        commandListOrig = (ListStartCommand) getChildren().get(COMMANDS_INDEX);
    }

    @Override
    public Command copy() {
        return new ForCommand();
    }
}
