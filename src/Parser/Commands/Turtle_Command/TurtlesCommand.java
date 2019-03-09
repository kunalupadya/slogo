package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class TurtlesCommand extends Command {

    public TurtlesCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController){
        setReturnValue(backendController.getMyTurtles().size());
    }

    @Override
    public Command copy() {
        return new TurtlesCommand();
    }
}