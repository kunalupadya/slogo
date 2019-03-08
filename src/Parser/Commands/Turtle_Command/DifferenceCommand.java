package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class DifferenceCommand extends Command {

    public DifferenceCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.abs(getChildren().get(0).getReturnValue() - getChildren().get(1).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new DifferenceCommand();
    }
}
