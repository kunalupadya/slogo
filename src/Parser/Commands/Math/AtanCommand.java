package Parser.Commands.Math;

import Parser.Commands.Command;


public class AtanCommand extends Command {

    public AtanCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  Math.atan(myChildrenList.get(0).getReturnValue());
    }

}
