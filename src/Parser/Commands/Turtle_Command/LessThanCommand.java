package Parser.Commands.Turtle_Command;


import Parser.BackendController;
import Parser.Commands.Command;

public class LessThanCommand extends BooleanCommand {

    public LessThanCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() < getChildren().get(1).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new LessThanCommand();
    }
}
