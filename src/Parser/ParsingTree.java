package Parser;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.RootCommand;
import Parser.Commands.Turtle_Command.*;
import Parser.Commands.Variable;

import java.util.*;

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
        this.backendController = backendController;
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
            if (savedCurrentCommand.getClass() == MakeUserInstructionCommand.class){
                currCommand = commandsList.remove(FIRST);
                currToken = tokensList.remove(FIRST);
                savedCurrentCommand.addChildren(currCommand);
                savedCurrentCommand.addChildren(makeTree(commandsList,tokensList,savedCurrentCommand));
                savedCurrentCommand.execute(backendController);
                parent.addChildren(savedCurrentCommand);
            }
            else if(savedCurrentCommand.getClass() == TextCommand.class){
                String text = savedCurrentCommand.getText();
                Optional<UserDefinedCommand> userDefinedCommand =  backendController.getUserDefinedCommand(text);
                if (userDefinedCommand.isPresent()){
                    UserDefinedCommand command = userDefinedCommand.get();
                    // TODO COPY THE TREE AND ADD IT HERE
//                    int numParameters = command.getNumParameters();
//                    for (Command child: myChildrenList){
//
//                    }
//
//                    command.getChildren().get(COMMANDS);
                }
                else {
                    // throw new TODO create exception, command not defined
                }
            }
            else if (savedCurrentCommand.getClass() == ConstantCommand.class){
                parent.addChildren(savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == Variable.class){
                parent.addChildren(savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == ListEndCommand.class){
                return savedCurrentCommand;
            }
            else if (savedCurrentCommand.getClass() == ListStartCommand.class){
                savedCurrentCommand.addChildren(makeTree(commandsList,tokensList, savedCurrentCommand));
                parent.addChildren(savedCurrentCommand);
                if (currCommand.getClass() != ListEndCommand.class){
                    //TODO Add error, list is missing the end brace "]"
                }
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
