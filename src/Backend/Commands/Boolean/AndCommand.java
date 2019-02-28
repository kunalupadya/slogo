package Backend.Commands.Boolean;

<<<<<<< HEAD:src/Backend/Commands/Boolean/AndCommand.java
import Backend.Commands.Command;

import java.util.ArrayList;

=======
>>>>>>> 75d29976848d91b951c5ed2c23b7952b782894c5:src/Parser/Commands/Boolean/AndCommand.java
public class AndCommand extends BooleanCommand{

    protected double execute(double a, double b){
        return returnValue(a != 0 && b !=0);
    }

    public int getNumParameters(){
        return 2;
    }

}
