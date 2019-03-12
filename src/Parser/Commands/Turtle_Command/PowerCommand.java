package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

public class PowerCommand extends BasicCommand {

    public PowerCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(Math.pow(getChildren().get(0).getReturnValue(),getChildren().get(1).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new PowerCommand();
    }
}
