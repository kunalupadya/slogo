package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SineCommand extends Command {

    public SineCommand(){
        setNumParameters(1);
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.sin(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

    @Override
    public Command copy() {
        return new SineCommand();
    }
}
