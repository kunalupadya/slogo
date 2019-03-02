package Parser.Commands.Math;

import Parser.Commands.Command;

public class CosCommand extends Command {

    public CosCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  Math.cos(myChildrenList.get(0).getReturnValue());
    }

}
