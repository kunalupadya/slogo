package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class TurtlesCommand extends Command {

    public TurtlesCommand(){
<<<<<<< HEAD
        setNumParameters(0);
=======
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 0;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    @Override
    protected void performAction(BackendController backendController){
        setReturnValue(backendController.getMyTurtles().size());
    }

    @Override
    public Command copy() {
        return new TurtlesCommand();
    }
}