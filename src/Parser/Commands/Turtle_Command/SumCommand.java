package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SumCommand extends Command {

    public SumCommand(){
<<<<<<< HEAD
        setNumParameters(2);
=======
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 2;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    public void performAction(BackendController backendController){
        setReturnValue(getChildren().get(0).getReturnValue() + getChildren().get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SumCommand();
    }
}
