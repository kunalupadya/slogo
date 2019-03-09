package Parser;

import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.RootCommand;
import Parser.Commands.Turtle_Command.*;
import Parser.Commands.Variable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author kunalupadya
 */
class ParsingTree {

    private static final int FIRST = 0;
    private Command headNode;
    private Command currCommand;
    private BackendController backendController;

    ParsingTree(List<Command> commandsList, BackendController backendController){
        headNode = new RootCommand();
        this.backendController = backendController;
        headNode = makeTree(commandsList, headNode);
    }

    Command getRoot(){
        return headNode;
    }

    private Command makeTree(List<Command> commandsList, Command parent){
        //System.out.println(parent.getClass());
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
            else if (savedCurrentCommand.getClass() == ListEndCommand.class||savedCurrentCommand.getClass() == GroupEndCommand.class){
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
                else {
                    parent.addChildren(makeTree(commandsList, savedCurrentCommand));
                }
            }
            if (parent.getNumParameters() == parent.getCurrentNumParameters()) {
                return parent;
            }
        }
        return parent;
    }

    private void handleTextCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) {
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
            // throw new TODO create exception, command not defined
        }
    }

    private void handleGroupStartCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand){
        currCommand = commandsList.remove(FIRST);
        savedCurrentCommand.addChildren(currCommand);
        savedCurrentCommand.addChildren(makeTree(commandsList, savedCurrentCommand));
        parent.addChildren(savedCurrentCommand);
        if (currCommand.getClass() != GroupEndCommand.class){
            //TODO Add error, list is missing the end brace "]"
        }
    }

    private void handleListStartCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) {
        savedCurrentCommand.addChildren(makeTree(commandsList, savedCurrentCommand));
        parent.addChildren(savedCurrentCommand);
        if (currCommand.getClass() != ListEndCommand.class){
            //TODO Add error, list is missing the end brace "]"
        }
    }

    private void handleUserDefinedCommand(List<Command> commandsList, Command parent, Command savedCurrentCommand) {
        currCommand = commandsList.remove(FIRST);
        String name = currCommand.getText();
        if (name == null){
            //throw new TODO make exception, user defined command name not valid
        }
        savedCurrentCommand.addChildren(currCommand);

        currCommand = commandsList.remove(FIRST);
        List<Variable> listOfVariableList = getVariables(commandsList, savedCurrentCommand);

        //create a placeholder userdefined command so that recursion works
        UserDefinedCommand newUserDefinedCommand = new UserDefinedCommand(name, listOfVariableList, null);
        backendController.addNewUserDefinedCommand(name, newUserDefinedCommand);

        //generate the command tree
        parent.addChildren(makeTree(commandsList,savedCurrentCommand));

        //create the actual userdefined command including the command tree
        savedCurrentCommand.execute(backendController);
    }

    private List<Variable> getVariables(List<Command> commandsList, Command savedCurrentCommand) {
        Command variablesList = handleVariablesList(commandsList, savedCurrentCommand);
        List<Variable> listOfVariableList = new LinkedList<>();
        //create variables list from current children list
        for (Command command: variablesList.getChildren()){
            if (command.getClass() == Variable.class){
                listOfVariableList.add((Variable) command);
            }
            else if (command.getClass() == ListEndCommand.class){
                //do nothing, don't throw exception
            }
            else{
                //throw new TODO create exception - variables list containes a non variable command
            }
        }
        return listOfVariableList;
    }

    private Command handleVariablesList(List<Command> commandsList, Command savedCurrentCommand) {
        Command variablesList = currCommand;
        if (variablesList.getClass() == ListStartCommand.class){
            handleListStartCommand(commandsList, savedCurrentCommand, variablesList);
        }
        else {
            //throw new TODO add exception missing variables list
        }
        return variablesList;
    }
}
