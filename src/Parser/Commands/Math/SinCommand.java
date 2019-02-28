package Parser.Commands.Math;

import Parser.Commands.Command;

public class SinCommand extends Command {

    public SinCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void execute(){
        returnValue =  Math.cos(myChildrenList.get(0).getReturnValue());
    }

}
