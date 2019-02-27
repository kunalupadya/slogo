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
        ParsingTree parsingTree = new ParsingTree(myCommandsList, myTokensList);
        Command headNode = parsingTree.getRoot();
    }

    public void runCommands(){
        //post traversal starting from headNode

    }
}
