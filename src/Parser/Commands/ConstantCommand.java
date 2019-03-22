package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class ConstantCommand extends BasicCommand {

    public ConstantCommand(Double input){
        setReturnValue(input);
        setIsEvaluated(true);
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {

    }

    @Override
    public Command copy() {
        return new ConstantCommand(getReturnValue());
    }
}