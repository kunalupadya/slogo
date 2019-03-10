package Parser.Commands;

import GraphicsBackend.Turtle;
import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class ConstantCommand extends Command {

    public ConstantCommand(Double input){
        setReturnValue(input);
        setIsEvaluated(true);
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {

    }

    @Override
    public Command copy() {
        return new ConstantCommand(getReturnValue());
    }
}