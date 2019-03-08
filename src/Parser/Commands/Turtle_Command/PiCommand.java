package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class PiCommand extends Command {

    public PiCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        returnValue = Math.PI;
    }

    @Override
    public Command copy() {
        return new PiCommand();
    }
}
