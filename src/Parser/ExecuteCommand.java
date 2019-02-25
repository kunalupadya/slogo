package Parser;


import java.util.ArrayList;

/**
 * @author Louis Lee
 */

public class ExecuteCommand {

    public ExecuteCommand(){
    }

    public void runCommands(ArrayList<Command> commandsList){
        for(int a=0; a<commandsList.size(); a++){
            commandsList[a].execute();
        }
    }
}
