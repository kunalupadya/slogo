package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class TangentCommand extends Command {

    public TangentCommand(){
        setNumParameters(1);
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.tan(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

    @Override
    public Command copy() {
        return new TangentCommand();
    }
}
