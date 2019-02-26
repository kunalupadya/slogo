package Parser.Commands.Boolean;

import Parser.Commands.Command;

public abstract class BooleanCommand implements Command {

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

}
