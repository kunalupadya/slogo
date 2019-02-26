package Parser;


import Parser.Commands.Command;

import java.util.ArrayList;

/**
 * @author Louis Lee
 */

public class ExecuteCommand {

    private ArrayList<Command> myCommandsList;
    private ArrayList<Token> myTokensList;

    public ExecuteCommand(ArrayList<Command> commandsList, ArrayList<Token> TokensList){
        myCommandsList = commandsList;
        myTokensList = TokensList;

    }
    public void runCommands(){

    }
}
