package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class ListStartCommand extends Command {
    public ListStartCommand(){
        isEvaluated = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
    }

    @Override
    protected void performAction(BackendController backendController) {
//        for (Command c:myChildrenList){
//            c.execute(backendController);
//        }
        returnValue = myChildrenList.size()-1;
    }

    @Override
    public Command copy() {
        return new ListStartCommand();
    }
}
