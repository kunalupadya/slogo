package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class ConstantCommand extends Command {

    public ConstantCommand(Double input){
        returnValue = input;
        isEvaluated = true;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
    }

    @Override
    public Command copy() {
        return new ConstantCommand(returnValue);
    }
}
