package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class GreaterThanCommand extends BooleanCommand {

    public GreaterThanCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() > getChildren().get(1).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new GreaterThanCommand();
    }
}
