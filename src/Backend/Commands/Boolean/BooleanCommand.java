package Backend.Commands.Boolean;

import Backend.Commands.Command;

import java.util.ArrayList;

public abstract class BooleanCommand implements Command{

    protected ArrayList<Command> childrenList = new ArrayList<>();

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

}
