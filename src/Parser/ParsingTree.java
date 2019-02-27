package Parser;

import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class ParsingTree {

    private List<Command> children;
    private String value;

    public ParsingTree(ArrayList<Command> commandsList, ArrayList<Token> TokensList){
        Command root = makeTree(commandsList, TokensList);
    }

    //we should make a new ExitCommand
    public Command makeTree(ArrayList<Command> commandsList, ArrayList<Token> TokensList){
        Command headNode = new ExitCommand();
        Command pointer = headNode;
        int numOfParameters;
        for(int a=0; a<commandsList.size() ; a++){

            pointer = commandsList.get(a);
            numOfParameters = pointer.numParameters();
            if(TokensList.get(a) ==Token.COMMAND){
                return makeTree(commandsList.subList(a+1,commandsList.size()), TokensList.subList(a+1,commandsList.size()));
            }
            pointer.addChildren(commandsList.subList(a+1, a+numOfParameters));

        }

    }



}
