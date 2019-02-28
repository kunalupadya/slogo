package Backend.Commands.Boolean;

import Backend.Commands.Command;

import java.util.ArrayList;

public abstract class BooleanCommand extends Command{

    protected ArrayList<Command> myChildrenList = new ArrayList<>();

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

}
