package Parser.Commands.Math;

import Parser.Commands.Command;

public class SumCommand extends Command {

    public SumCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void execute(){
        returnValue =  myChildrenList.get(0).getReturnValue() + myChildrenList.get(1).getReturnValue();
    }

}
