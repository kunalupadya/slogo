package Parser.Commands.Math;

import Parser.Commands.Command;

public class DifferenceCommand extends Command {

    public DifferenceCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void execute(){
        returnValue =  Math.abs(myChildrenList.get(0).getReturnValue() - myChildrenList.get(1).getReturnValue());
    }


}
