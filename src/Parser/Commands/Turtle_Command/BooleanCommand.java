package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;

public abstract class BooleanCommand extends Command{

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

}
