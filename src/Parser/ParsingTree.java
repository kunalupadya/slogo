package Parser;

import Parser.Commands.Command;
import Parser.Commands.RootCommand;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ParsingTree {

    public static final int FIRST = 0;
    private List<Command> children;
    private String value;
//    private HandleError handleError;
    Command headNode;
    Command currCommand;
    Token currToken;
    List<Command> commands;
    List<Token> tokens;


    public ParsingTree(List<Command> commandsList, List<Token> tokensList){
        headNode = new RootCommand();
        commands = commandsList;
        tokens = tokensList;
        headNode = makeTree(commandsList, tokensList, headNode);
    }

    public Command getRoot(){
        return headNode;
    }

    public Command makeTree(List<Command> commandsList, List<Token> tokensList, Command parent){
        while (!commandsList.isEmpty()) {
            System.out.println();
            currCommand = commandsList.remove(FIRST);
            currToken = tokensList.remove(FIRST);
            Command savedCurrentCommand = currCommand;
            Token savedCurrentToken = currToken;

            System.out.println(commandsList);
            System.out.println(tokensList);
            if (currToken == Token.CONSTANT) {
                parent.addChildren(savedCurrentCommand);
            }
            else if (currToken == Token.LIST_END){
                return savedCurrentCommand;
            }
            else if (currToken == Token.LIST_START){
                while (currToken!=Token.LIST_END){
                    savedCurrentCommand.addChildren(makeTree(commandsList,tokensList, savedCurrentCommand));
                }
                parent.addChildren(savedCurrentCommand);
            }
            else{

                parent.addChildren(makeTree(commandsList,tokensList, savedCurrentCommand));
            }
            if (parent.getNumParameters() == parent.getCurrentNumParameters()) {
                return parent;
            }
        }
        return parent;
    }
}
