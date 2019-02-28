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

    public ParsingTree(List<Command> commandsList, List<Token> TokensList){
        myRoot = makeTree(commandsList, TokensList);
    }

    public RootCommand getRoot(){
        return myRoot;

    }

    //we should make a new ExitCommand
    public RootCommand makeTree(List<Command> commandsList, List<Token> TokensList){
        RootCommand headNode = new RootCommand();
        Command head = headNode;
        Command pointer;
        int numOfParameters;
        try {
            for (int a = 0; a < commandsList.size(); a++) {
                pointer = commandsList.get(a);
                head.addChildren(pointer);
                numOfParameters = pointer.getNumParameters();
                Token token = TokensList.get(a);
                if (token == Token.COMMAND) {
                    pointer.addChildrenList(commandsList.subList(a + 1, a + numOfParameters));
                    return makeTree((ArrayList<Command>)commandsList.subList(a + 1, commandsList.size()), (ArrayList<Token>)TokensList.subList(a + 1, commandsList.size()));
                }
                if (token == Token.GROUP_START) {
                    for (int b = a; b < commandsList.size(); b++)
                        if (TokensList.get(b) == Token.GROUP_END) {
                            pointer.addChildrenList(commandsList.subList(a + 1, b));
                            return makeTree((ArrayList<Command>)commandsList.subList(a + 1, b), (ArrayList<Token>)TokensList.subList(a + 1, b));
                        }
                }
                if (token == Token.LIST_START) {
                    for (int b = a; b < commandsList.size(); b++)
                        if (TokensList.get(b) == Token.LIST_END) {
                            pointer.addChildrenList(commandsList.subList(a + 1, b));
                            return makeTree((ArrayList<Command>)commandsList.subList(a + 1, b), (ArrayList<Token>)TokensList.subList(a + 1, b));
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
    return headNode;
    }

}
