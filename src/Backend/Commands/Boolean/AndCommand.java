package Backend.Commands.Boolean;

import Backend.Commands.Command;

import java.util.ArrayList;

public class AndCommand extends BooleanCommand{

    protected double execute(double a, double b){
        return returnValue(a != 0 && b !=0);
    }

    public int getNumParameters(){
        return 2;
    }

}
