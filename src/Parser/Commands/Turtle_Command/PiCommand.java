package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class PiCommand extends Command {

    public PiCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = true;
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.PI);
    }

    @Override
    public Command copy() {
        return new PiCommand();
    }
}
