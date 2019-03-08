package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class IfCommand extends Command {

    public static final int EXPRESSION_INDEX = 0;
    public static final int LIST_INDEX = 1;

    public IfCommand(){
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (getChildren().get(EXPRESSION_INDEX).getReturnValue() == 0){
            getChildren().get(LIST_INDEX).setIsEvaluated(true);
        }
    }

    @Override
    public Command copy() {
        return new IfCommand();
    }
}
//
//    private final int commandList = 1;
//
//    public IfCommand() {
//        super();
//        isEvaluated = false;
//        numParameters = 2;
//    }
//
//    @Override
//    protected void performAction(BackendController backendController) {
//        if (initialExpressions.get(0).getReturnValue() != 0) {
//            setListToRun((ListStartCommand) myChildrenList.get(commandList));
//        }
//        runAgain = false;
//    }
//
//    @Override
//    public void setInitialExpressions() {
//        initialExpressions.add(myChildrenList.get(0));
//    }
//
//    @Override
//    public void setUpLoop() { }
//
//
//    @Override
//    public Command copy() {
//        return new IfCommand();
//    }
//}
