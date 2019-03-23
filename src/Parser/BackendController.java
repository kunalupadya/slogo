package Parser;

import GUI.FrontendController;
import GraphicsBackend.*;
import Parser.Commands.Turtle_Command.ImmutableUserDefinedCommand;
import Parser.Commands.Turtle_Command.UserDefinedCommand;
import Parser.Commands.Variable;
import javafx.scene.paint.Color;
import java.util.*;

/**
 * This class is the main external API for the backend. It communicates with the front end through the frontEndController
 * and initiates all operations in the backend.
 *
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
     *gets the names of all available commands
     * @return
     */
    public Set<String> getAllCommandNames() {
        return userDefinedCommands.keySet();
    }

    /**
     * gets the names of all available variables
     * @return
     */
    public Set<String> getAllVariableNames() {
        return availableVariables.keySet();
    }

    /**
     * sets the language of commands to the inputted language
     * @param language
     */
    public void setCommandLanguage(String language){
        commandLanguage = language;
    }

    /**
     * gets an immutable grid
     * @return
     */
    public ImmutableGrid getMyGrid() {
        return myGrid;
    }

    /**
     * a way of getting all turtles meant for backend access
     * @return
     */
    public List<Turtle> getMyTurtles() {
        return myTurtles;
    }

    /**
     * a way of getting all turtles meant for frontend access
     * @return
     */
    public List<FrontendImmutableTurtle> getFrontendImmutableTurtles(){
        List<FrontendImmutableTurtle> frontendImmutableTurtles = new ArrayList<>();
        for (Turtle turtle:myTurtles){
            frontendImmutableTurtles.add(turtle.getFrontendImmutableTurtle());
        }
        return frontendImmutableTurtles;
    }

    /**
     * sends error messages to the frontend
     * @param string
     */
    void showErrorMessage(String string){
        frontendController.consoleShowError(string);
    }

    /**
     * sets the frontend controller
     * @param frontendController
     */
    public void setFrontendController(FrontendController frontendController) {
        this.frontendController = frontendController;
    }

    /**
     * parses and runs a string that has been sent from the console
     * @param userInput
     */
    public void parseAndRun(String userInput){
        ParseCommand parser = new ParseCommand(userInput, commandLanguage, this);
    }

    /**
     * returns the current color palette index
     * @param color
     * @return
     */
    public int getColorPaletteIndex(Color color){
        return myPalette.getColorIndex(color);
    }

    /**
     * returns all the colors in the color palette
     * @return
     */
    public Color[] getColorPalette(){
        return myPalette.getColorPalette();
    }

    /**
     * gets the color of the palette
     * @param index
     * @return
     */
    public Color getColor(int index){
        return myPalette.getColor(index);
    }

    /**
     * adds a color to the palette
     * @param index
     * @param color
     */
    public void addColorToPalette(int index, Color color){
        myPalette.setMyColorPalette(index, color);
    }

    /**
     * sets the background color by a color
     * @param color
     */
    public void setBackGroundColor(Color color){
        frontendController.setBackgroundColor(color);
    }

    /**
     * undoes a command
     */
    public void undo(){
        for (Turtle turtle: myTurtles){
            if (turtle.getIsTurtleActive()) {
                turtle.undo();
            }
        }
    }

    /**
     * sends the output to the console
     * @param commandOutput
     */
    void outputResultToConsole(String commandOutput) {
        frontendController.consoleShowCommandOutput(commandOutput);
    }
}