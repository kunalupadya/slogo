package Parser;

import Parser.Commands.Command;
import Parser.Commands.RootCommand;

import java.util.ArrayList;
import java.util.List;

public class ParsingTree {

    private List<Command> children;
    private String value;
    private HandleError handleError;
    RootCommand myRoot;
    RootCommand headNode;


    public ParsingTree(List<Command> commandsList, List<Token> TokensList){
        headNode = new RootCommand();
        makeTree(commandsList, TokensList, headNode);
    }

    public RootCommand getRoot(){
        return headNode;

    }


    public

    //we should make a new ExitCommand
    public Command makeTree(List<Command> commandsList, List<Token> TokensList, Command parent){
        Command pointer;
        int numOfParameters;
        try {
            for (int a = 0; a < commandsList.size(); a++) {
                pointer = commandsList.get(a);
                parent.addChildren(pointer);
                numOfParameters = pointer.getNumParameters();
                Token token = TokensList.get(a);
                if (token == Token.COMMAND) {
                    pointer.addChildrenList(commandsList.subList(a + 1, a + numOfParameters));
                    return makeTree(commandsList.subList(a + 1, commandsList.size()), TokensList.subList(a + 1, commandsList.size()), pointer);
                }
                if (token == Token.GROUP_START) {
                    for (int b = a; b < commandsList.size(); b++)
                        if (TokensList.get(b) == Token.GROUP_END) {
                            pointer.addChildrenList(commandsList.subList(a + 1, b));
                            return makeTree(commandsList.subList(a + 1, b), TokensList.subList(a + 1, b), pointer);
                        }
                }
                if (token == Token.LIST_START) {
                    for (int b = a; b < commandsList.size(); b++)
                        if (TokensList.get(b) == Token.LIST_END) {
                            pointer.addChildrenList(commandsList.subList(a + 1, b));
                            return makeTree(commandsList.subList(a + 1, b), TokensList.subList(a + 1, b), pointer);
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
    return parent;
    }

}
