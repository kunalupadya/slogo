package Parser.Commands.Boolean;

import Parser.Commands.Command;

public class AndCommand extends BooleanCommand{

    protected double execute(double a, double b){
        return returnValue(a != 0 && b !=0);
    }

    protected int numParameters(){
        return 2;
    }
}
