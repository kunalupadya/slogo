package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class QuotientCommand extends Command {

    public QuotientCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
    }

    public void performAction(BackendController backendController){
        setReturnValue(getChildren().get(0).getReturnValue() / getChildren().get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new QuotientCommand();
    }
}
