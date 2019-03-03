package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class PiCommand extends Command {

    public PiCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        returnValue = Math.PI;
    }


}
