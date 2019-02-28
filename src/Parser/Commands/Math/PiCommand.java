package Parser.Commands.Math;

import Parser.Commands.Command;

public class PiCommand extends Command {

    public PiCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void execute(){
        returnValue = Math.PI;
    }


}
