package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;

public class SinCommand extends Command {

    public SinCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  Math.cos(myChildrenList.get(0).getReturnValue());
    }

}
