package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SineCommand extends Command {

    public SineCommand(){
<<<<<<< HEAD
        setNumParameters(1);
=======
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 1;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.sin(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

    @Override
    public Command copy() {
        return new SineCommand();
    }
}
