package Parser.Commands.Turtle_Command;

import Parser.Commands.BasicCommand;

/**
 * This abstract defines a returnValue() method to facilitate performAction() methods in Boolean Commands.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
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
