package Parser;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.RootCommand;
import Parser.Commands.Turtle_Command.ListEndCommand;
import Parser.Commands.Turtle_Command.MakeUserInstructionCommand;
import Parser.Commands.Variable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ParsingTree {

    public static final int FIRST = 0;
    private List<Command> children;
    private String value;

    Command headNode;
    Command currCommand;
    Token currToken;
    List<Command> commands;
    List<Token> tokens;
    BackendController backendController;


    public ParsingTree(List<Command> commandsList, List<Token> tokensList, BackendController backendController){
        headNode = new RootCommand();
        commands = commandsList;
        tokens = tokensList;
        headNode = makeTree(commandsList, tokensList, headNode);
        this.backendController = backendController;
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
            if (savedCurrentCommand.getClass() == MakeUserInstructionCommand.class){
                currCommand = commandsList.remove(FIRST);
                currToken = tokensList.remove(FIRST);
                savedCurrentCommand.addChildren(currCommand);
                savedCurrentCommand.addChildren(makeTree(commandsList,tokensList,savedCurrentCommand));
                savedCurrentCommand.execute(backendController);
            }
            else if (savedCurrentCommand.getClass() == ConstantCommand.class){
                parent.addChildren(savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == Variable.class){
                parent.addChildren(savedCurrentCommand);
            }
            else if (currToken == Token.LIST_END){
                return savedCurrentCommand;
            }
            else if (currToken == Token.LIST_START){
//                while (currToken!=Token.LIST_END){
                    savedCurrentCommand.addChildren(makeTree(commandsList,tokensList, savedCurrentCommand));
                    parent.addChildren(savedCurrentCommand);
                    if (currCommand.getClass() != ListEndCommand.class){
                        //TODO Add error, list is missing the end brace "]"
                    }
//                    currCommand = commandsList.remove(FIRST);
//                    currToken = tokensList.remove(FIRST);
//                    savedCurrentCommand = currCommand;
//                    savedCurrentToken = currToken;
//                }
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
