package Parser;


import GUI.FrontendController;
import GraphicsBackend.*;
import Parser.Commands.Turtle_Command.ImmutableUserDefinedCommand;
import Parser.Commands.Turtle_Command.UserDefinedCommand;
import Parser.Commands.Variable;
import javafx.scene.paint.Color;

import java.util.*;

/**
 * @author kunalupadya
 */
public class BackendController {

    private String commandLanguage;
    private Grid myGrid;
    private List<Turtle> myTurtles = new ArrayList<>();
    private Map<String, ImmutableUserDefinedCommand> userDefinedCommands;
    private Map<String, Variable> availableVariables;
    private List<UserDefinedCommand> userDefinedCommandStack = new LinkedList<>();
    private FrontendController frontendController;
    private Palette myPalette;

    /**
     * the backend controller holds all the instances that make up the backend
     */
    public BackendController(){
        myGrid = new Grid(400,400);
        userDefinedCommands = new HashMap<>();
        availableVariables = new HashMap<>();
        myTurtles.add(new Turtle(myGrid));
        myPalette = new Palette();
    }

    /**
     * adds a new user defined command to the map, called when a makeuserdefinedcommand is executed in executecommand
     * @param commandName the string name of the command
     * @param tree the actual userdefinedcommand
     */
    public void addNewUserDefinedCommand(String commandName, ImmutableUserDefinedCommand tree){
        userDefinedCommands.put(commandName,tree);
    }

    /**
     * creates a new variable in the variables map, called when a makevariable command is executed in executecommand
     * @param variableName the string name of the variable
     * @param variable the variable
     */
    public void addOrReplaceVariable(String variableName, Variable variable){
        availableVariables.put(variableName, variable);
    }

    /**
     * adds a user defined command to the stack of userdefined commands, used when a user defined command is encountered
     * @param userDefinedCommand
     */
    public void addUserDefinedCommandToStack(UserDefinedCommand userDefinedCommand){
        userDefinedCommandStack.add(userDefinedCommand);
    }

    /**
     * removes a user defined command from the stack, used when the command is finished executing
     * @param userDefinedCommand
     */
    public void removeUserDefinedCommandFromStack(UserDefinedCommand userDefinedCommand){
        userDefinedCommandStack.remove(userDefinedCommand);
    }

    /**
     * gets the variable if it exists from the variables or the top of the userdefinedcommand stack
     * @param variableName
     * @return variable
     */
    public Optional<Double> getVariableIfExists(String variableName){
        if (availableVariables.containsKey(variableName)){
            Double returnValue = availableVariables.get(variableName).getReturnValue();
            return Optional.of(returnValue);
        }
        if (userDefinedCommandStack.size() != 0) {
            List<Variable> stackVariables = userDefinedCommandStack.get(userDefinedCommandStack.size() - 1).getVariables();
            for (Variable v : stackVariables) {
                if (v.getText().equals(variableName)) {
                    Double returnValue = v.getReturnValue();
                    return Optional.of(returnValue);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * gets the userdefined command if it exists
     * @param commandName
     * @return
     */
    public Optional<ImmutableUserDefinedCommand> getUserDefinedCommand(String commandName){
        if (userDefinedCommands.containsKey(commandName)){
            return Optional.of(userDefinedCommands.get(commandName));
        }
        return Optional.empty();
    }

    /**
     *
     * @return
     */
    public Set<String> getAllCommands() {
        return userDefinedCommands.keySet();
    }

    public Set<String> getAllVariables() {
        return availableVariables.keySet();
    }

    public void setCommandLanguage(String language){
        commandLanguage = language;
    }

    public ImmutableGrid getMyGrid() {
        return myGrid;
    }

    //meant for backend access
    public List<Turtle> getMyTurtles() {
        return myTurtles;
    }

    //meant for frontend access
    public List<FrontendImmutableTurtle> getFrontendImmutableTurtles(){
        List<FrontendImmutableTurtle> frontendImmutableTurtles = new ArrayList<>();
        for (Turtle turtle:myTurtles){
            frontendImmutableTurtles.add(turtle.getFrontendImmutableTurtle());
        }
        return frontendImmutableTurtles;
    }

    void showErrorMessage(String string){
        frontendController.consoleShowError(string);
    }

    public void setFrontendController(FrontendController frontendController) {
        this.frontendController = frontendController;
    }

    public void parseAndRun(String userInput){
        ParseCommand parser = new ParseCommand(userInput, commandLanguage, this);
    }

    public int getColorPaletteIndex(Color color){
        return myPalette.getColorIndex(color);
    }

    public Color[] getColorPalette(){
        return myPalette.getColorPalette();
    }

    public Color getColor(int index){
        return myPalette.getColor(index);
    }

    public void setMyPalette(int index, Color color){
        myPalette.setMyColorPalette(index, color);
    }

    public void setBackGroundColor(Color color){
        frontendController.setBackgroundColor(color);
    }

    public void undo(){
        for (Turtle turtle: myTurtles){
            if (turtle.getIsTurtleActive()) {
                turtle.undo();
            }
        }
    }

    void outputResultToConsole(String commandOutput) {
        frontendController.consoleShowCommandOutput(commandOutput);
    }
}