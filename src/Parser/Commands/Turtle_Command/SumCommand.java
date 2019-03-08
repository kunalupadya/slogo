package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SumCommand extends Command {

    public SumCommand(){
        setNumParameters(2);
    }

    public void performAction(BackendController backendController){
        setReturnValue(getChildren().get(0).getReturnValue() + getChildren().get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SumCommand();
    }
}
