package Parser.Commands.Boolean;

import Parser.Commands.Command;

import java.util.ArrayList;

public abstract class BooleanCommand extends Command{

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

}
