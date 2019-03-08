package Parser.Commands;

import Parser.BackendController;

public class ConstantCommand extends Command {

    public ConstantCommand(Double input){
        returnValue = input;
        isConstant = true;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
    }

    @Override
    public Command copy() {
        return new ConstantCommand(returnValue);
    }
}
