package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;

public class LogCommand extends Command {

    public LogCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  Math.log(myChildrenList.get(0).getReturnValue());
    }

}
