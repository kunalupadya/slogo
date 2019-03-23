package Parser.Commands.Turtle_Command;

import Parser.Commands.BasicCommand;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


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
