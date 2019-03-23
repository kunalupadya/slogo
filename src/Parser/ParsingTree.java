package Parser;

import Parser.Commands.*;
import Parser.Commands.Turtle_Command.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * This class constructs a tree of commands for execution from a list of commands.
 *
 * @author kunalupadya
 */
class ParsingTree {

    private static final int FIRST = 0;
    private Command headNode;
    private Command currCommand;
    private BackendController backendController;

    ParsingTree(List<Command> commandsList, BackendController backendController) throws SLogoException{
        headNode = new RootCommand();
        this.backendController = backendController;
        headNode = makeTree(commandsList, headNode);
    }

    Command getRoot(){
        return headNode;
    }

    private Command makeTree(List<Command> commandsList, Command parent) throws SLogoException{
        while (!commandsList.isEmpty()) {
            currCommand = commandsList.remove(FIRST);
            Command savedCurrentCommand = currCommand;
            if (savedCurrentCommand.getClass() == MakeUserInstructionCommand.class){
                handleUserDefinedCommand(commandsList, parent, savedCurrentCommand);
            }
            else if(savedCurrentCommand.getClass() == TextCommand.class){
                handleTextCommand(commandsList, parent, savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == ConstantCommand.class){
                parent.addChildren(savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == Variable.class){
                parent.addChildren(savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == ListEndCommand.class || savedCurrentCommand.getClass() == GroupEndCommand.class){
                return savedCurrentCommand;
            }
            else if (savedCurrentCommand.getClass() == ListStartCommand.class){
                handleListStartCommand(commandsList, parent, savedCurrentCommand);
            }
            else if (savedCurrentCommand.getClass() == GroupStartCommand.class){
                handleGroupStartCommand(commandsList, parent, savedCurrentCommand);
            }
            else{
                if (savedCurrentCommand.getNumParameters() == savedCurrentCommand.getCurrentNumParameters()) {
                    parent.addChildren(savedCurrentCommand);
                }
                else{
                    if (commandsList.isEmpty()){
                        String currCommandClass = savedCurrentCommand.getClass().toString();
                        String prefix = "class Parser.Commands.Turtle_Command.";
                        String command = currCommandClass.substring(prefix.length());
                        throw new ParserException(command + " is missing one or more parameters");
                    }
                    parent.addChildren(makeTree(commandsList, savedCurrentCommand));
                }
            }
            if (parent.getNumParameters() == parent.getCurrentNumParameters()) {
                return parent;
            }
        }
        return parent;
    }

    private void handleTextCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) throws SLogoException{
        String text = savedCurrentCommand.getText();
        Optional<ImmutableUserDefinedCommand> userDefinedCommand = backendController.getUserDefinedCommand(text);
        if (userDefinedCommand.isPresent()){
            ImmutableUserDefinedCommand command = userDefinedCommand.get();
            savedCurrentCommand.setNumParameters(command.getVariables().size());
            if (savedCurrentCommand.getNumParameters() != 0) {
                parent.addChildren(makeTree(commandsList, savedCurrentCommand));
            }
            else {
                parent.addChildren(savedCurrentCommand);
            }
        }
        else {
            throw new ParserException(text + " command is not defined");
        }
    }

    private void handleGroupStartCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) throws SLogoException{
        currCommand = commandsList.remove(FIRST);
        if (currCommand instanceof MakeUserInstructionCommand){
            throw new ParserException("Group commands cannot make User Defined Commands");
        }
        if (currCommand instanceof TextCommand){
            String text = currCommand.getText();
            Optional<ImmutableUserDefinedCommand> userDefinedCommand = backendController.getUserDefinedCommand(text);
            if (userDefinedCommand.isPresent()){
                ImmutableUserDefinedCommand command = userDefinedCommand.get();
                currCommand.setNumParameters(command.getVariables().size());
            }
            else {
                throw new ParserException(text + " command is not defined");
            }
        }
        savedCurrentCommand.addChildren(currCommand);
        savedCurrentCommand.addChildren(makeTree(commandsList, savedCurrentCommand));
        parent.addChildren(savedCurrentCommand);
        if (currCommand.getClass() != GroupEndCommand.class){
            throw new ParserException("Group is missing end parenthesis");
        }
    }

    private void handleListStartCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) throws SLogoException{
        savedCurrentCommand.addChildren(makeTree(commandsList, savedCurrentCommand));
        parent.addChildren(savedCurrentCommand);
        if (currCommand.getClass() != ListEndCommand.class){
            throw new ParserException("List is missing end bracket");
        }
    }

    private void handleUserDefinedCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) throws SLogoException{
        currCommand = commandsList.remove(FIRST);
        String name = currCommand.getText();
        if (name == null){
            throw new ParserException("Name is not valid for User Defined Command");
        }
        savedCurrentCommand.addChildren(currCommand);

        currCommand = commandsList.remove(FIRST);
        List<Variable> listOfVariableList = getVariables(commandsList, savedCurrentCommand);

        //create a placeholder user defined command so that recursion works
        UserDefinedCommand newUserDefinedCommand = new UserDefinedCommand(name, listOfVariableList, null);
        backendController.addNewUserDefinedCommand(name, newUserDefinedCommand);

        //generate the command tree
        parent.addChildren(makeTree(commandsList,savedCurrentCommand));

        //create the actual user defined command including the command tree
        ((BasicCommand)savedCurrentCommand).execute(backendController);
    }

    private List<Variable> getVariables(List<Command> commandsList, Command savedCurrentCommand) throws SLogoException{
        Command variablesList = handleVariablesList(commandsList, savedCurrentCommand);
        List<Variable> listOfVariableList = new LinkedList<>();
        //create variables list from current children list
        for (Command command: variablesList.getChildren()){
            if (command.getClass() == Variable.class){
                listOfVariableList.add((Variable) command);
            }
            else if (command.getClass() == ListEndCommand.class){
                //do nothing, don't throw exception
                break;
            }
            else{
                throw new ParserException("Variable List for new UserDefined Command has a non-Variable input");
            }
        }
        return listOfVariableList;
    }

    private Command handleVariablesList(List<Command> commandsList, Command savedCurrentCommand) throws SLogoException{
        Command variablesList = currCommand;
        if (variablesList.getClass() == ListStartCommand.class){
            handleListStartCommand(commandsList, savedCurrentCommand, variablesList);
        }
        else {
            throw new ParserException("New UserDefined Command is missing list of Variables");
        }
        return variablesList;
    }
}
