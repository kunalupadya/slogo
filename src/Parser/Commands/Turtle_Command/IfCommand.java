package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class IfCommand extends ControlCommand{

    private final int EXPRESSION_INDEX = 0;
    private final int COMMANDS_INDEX = 1;

    public IfCommand() {
        super();
        isEvaluated = false;
        numParameters = 2;
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (initialExpressions.get(EXPRESSION_INDEX).getReturnValue() != 0) {
            setListToRun((ListStartCommand) myChildrenList.get(COMMANDS_INDEX));
        }
        runAgain = false;
    }

    @Override
    public void setInitialExpressions() {
        initialExpressions.add(myChildrenList.get(EXPRESSION_INDEX));
    }

    @Override
    public void setUpLoop() { }


    @Override
    public Command copy() {
        return new IfCommand();
    }
}
//public class IfCommand extends Command {
//
//    public static final int EXPRESSION_INDEX = 0;
//    public static final int LIST_INDEX = 1;
//
//    public IfCommand(){
//        numParameters = 2;
//        isEvaluated = false;
//    }
//
//    @Override
//    protected void performAction(BackendController backendController) {
//        if (myChildrenList.get(EXPRESSION_INDEX).getReturnValue() == 0){
//            myChildrenList.get(LIST_INDEX).setIsEvaluated(true);
//        }
//    }
//
//    @Override
//    public Command copy() {
//        return new IfCommand();
//    }
//}

