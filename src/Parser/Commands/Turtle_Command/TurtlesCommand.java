package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class TurtlesCommand extends Command {

    public TurtlesCommand(){
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        returnValue = backendController.getMyTurtles().size();
    }

    @Override
    public Command copy() {
        return new TurtlesCommand();
    }
}