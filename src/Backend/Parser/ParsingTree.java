package Backend.Parser;

import Backend.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class ParsingTree {

    private List<Command> children;
    private String value;
    private HandleError handleError;
    Command myRoot;

    public ParsingTree(ArrayList<Command> commandsList, ArrayList<Token> TokensList){
        myRoot = makeTree(commandsList, TokensList);
    }

    public Command getRoot(){
        return myRoot;

    }

    //we should make a new ExitCommand
    public Command makeTree(ArrayList<Command> commandsList, ArrayList<Token> TokensList){
        Command headNode = new ExitCommand();
        Command head = headNode;
        Command pointer;
        int numOfParameters;
        try {
            for (int a = 0; a < commandsList.size(); a++) {
                pointer = commandsList.get(a);
                head.addChildren(pointer);
                numOfParameters = pointer.numParameters();
                Token token = TokensList.get(a);
                if (token == Token.COMMAND) {
                    pointer.addChildrenList(commandsList.subList(a + 1, a + numOfParameters));
                    return makeTree(commandsList.subList(a + 1, commandsList.size()), TokensList.subList(a + 1, commandsList.size()));
                }
                if (token == Token.GROUP_START) {
                    for (int b = a; b < commandsList.size(); b++)
                        if (TokensList.get(b) == Token.GROUP_END) {
                            pointer.addChildrenList(commandsList.subList(a + 1, b));
                            return makeTree(commandsList.subList(a + 1, b), TokensList.subList(a + 1, b));
                        }
                }
                if (token == Token.LIST_START) {
                    for (int b = a; b < commandsList.size(); b++)
                        if (TokensList.get(b) == Token.LIST_END) {
                            pointer.addChildrenList(commandsList.subList(a + 1, b));
                            return makeTree(commandsList.subList(a + 1, b), TokensList.subList(a + 1, b));
                        }
                }
                if (token == Token.CONSTANT) {
                    pointer.addChildren(commandsList.get(a));
                }
                if (token == Token.VARIABLE) {
                    pointer.addChildren(commandsList.get(a));
                }

            }
        }catch (Exception e){

        }
    return head;
    }

}
