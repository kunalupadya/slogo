package Parser.Commands.Turtle_Command;

import Parser.Commands.BasicCommand;

public abstract class BooleanCommand extends BasicCommand{

    BooleanCommand(){
        isOutputCommand = true;
    }

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }
}
