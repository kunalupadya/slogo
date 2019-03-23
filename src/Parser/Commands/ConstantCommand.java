package Parser.Commands;

import Parser.BackendController;

/**
 * This Command class represents constant numerical values.
 *
 * @author kunalupadya
 */
public class ConstantCommand extends BasicCommand {

    /**
     * Constant Command Constructor
     * @param input value of constant
     */
    public ConstantCommand(Double input){
        setReturnValue(input);
        setIsEvaluated(true);
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {

    }

    /**
     * Returns copy of command
     *
     * @return copy of command
     */
    @Override
    public Command copy() {
        return new ConstantCommand(getReturnValue());
    }
}