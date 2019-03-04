package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class ListStartCommand extends Command {
    public ListStartCommand(){
        isConstant = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
    }

    @Override
    protected void performAction(BackendController backendController) {
//        for (Command c:myChildrenList){
//            c.execute(backendController);
//        }
    }
}
