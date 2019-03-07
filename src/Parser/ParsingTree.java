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
    List<Command> potentialRecursionList = new LinkedList<>();


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
                String name = currCommand.getText();
                if (name == null){
                    //throw new TODO make exception, user defined command name not valid
                }
                savedCurrentCommand.addChildren(currCommand);
                currCommand = commandsList.remove(FIRST);
                currToken = tokensList.remove(FIRST);
                Command variablesList = currCommand;
                if (variablesList.getClass() == ListStartCommand.class){
                    variablesList.addChildren(makeTree(commandsList,tokensList, variablesList));
                    savedCurrentCommand.addChildren(variablesList);
                    if (currCommand.getClass() != ListEndCommand.class){
                        //TODO Add error, list is missing the end brace "]"
                    } //TODO make this extracted from the list start command class
                }
                else {
                    //throw new TODO add exception missing variables list
                }
                List<Variable> listOfVariableList = new LinkedList<>();
                //create variables list from current children list
                for (Command command: variablesList.getChildren()){
                    if (command.getClass() == Variable.class){
                        listOfVariableList.add((Variable) command);
                    }
                    else if (command.getClass() == ListEndCommand.class){
                        //do nothing
                    }
                    else{
                        //throw new TODO create exception - variables list containes a non variable command
                    }
                }
                UserDefinedCommand newUserDefinedCommand = new UserDefinedCommand(name, listOfVariableList, null);
                backendController.addNewUserDefinedCommand(name, newUserDefinedCommand);
                parent.addChildren(makeTree(commandsList,tokensList,savedCurrentCommand));
                savedCurrentCommand.execute(backendController);
//                parent.addChildren(savedCurrentCommand);
            }
            else if(savedCurrentCommand.getClass() == TextCommand.class){
                String text = savedCurrentCommand.getText();
                Optional<UserDefinedCommand> userDefinedCommand = backendController.getUserDefinedCommand(text);
                if (userDefinedCommand.isPresent()){
                    UserDefinedCommand command = userDefinedCommand.get();
                    savedCurrentCommand.setNumParameters(command.getVariables().size());
                    parent.addChildren(makeTree(commandsList,tokensList, savedCurrentCommand));
//                    parent.addChildren(savedCurrentCommand);
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
