package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class ConstantCommand extends Command {

    public ConstantCommand(Double input){
<<<<<<< HEAD
        setReturnValue(input);
        setIsEvaluated(true);
        setNumParameters(0);
=======
        returnValue = input;
        isEvaluated = true;
        numParameters = 0;
        isOutputCommand = false;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    public void performAction(BackendController backendController){
    }

    @Override
    public Command copy() {
        return new ConstantCommand(getReturnValue());
    }
}