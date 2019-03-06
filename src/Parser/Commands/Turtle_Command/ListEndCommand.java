package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class ListEndCommand extends Command {
    public ListEndCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController) {
//        for (Command c:myChildrenList){
//            c.execute(backendController);
//        }
    }

    @Override
    public Command copy() {
        return new ListEndCommand();
    }
}
