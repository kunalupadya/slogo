package Parser.Commands.Math;

import Parser.Commands.Command;

public class LogCommand extends Command {

    public LogCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void execute(){
        returnValue =  Math.log(myChildrenList.get(0).getReturnValue());
    }

}
