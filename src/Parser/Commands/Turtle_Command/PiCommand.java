package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;

public class PiCommand extends Command {

    public PiCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        returnValue = Math.PI;
    }


}
