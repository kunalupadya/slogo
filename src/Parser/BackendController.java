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
    private List<Boolean> previousTurtleTell;
    private List<Turtle> askWithList;
    private Palette myPalette;

    public BackendController(){
        myGrid = new Grid(400,400);
        userDefinedCommands = new HashMap<>();
        availableVariables = new HashMap<>();
        myTurtles.add(new Turtle(myGrid));
        myPalette = new Palette();
    }

    public void recordTurtleTell(){
        previousTurtleTell = new LinkedList<>();
        for (Turtle t: myTurtles){
            previousTurtleTell.add(t.getIsTurtleActive());
        }
    }

    public void loadTurtleTell(){
        int ctr = 0;
        for (Boolean b: previousTurtleTell){
            myTurtles.get(ctr).setTurtleActive(b);
            ctr++;
        }
    }

    public void addNewUserDefinedCommand(String commandName, ImmutableUserDefinedCommand tree){
        userDefinedCommands.put(commandName,tree);
    }

    public void addOrReplaceVariable(String variableName, Variable variable){
        availableVariables.put(variableName, variable);
    }

    public void addUserDefinedCommandToStack(UserDefinedCommand userDefinedCommand){
        userDefinedCommandStack.add(userDefinedCommand);
    }

    public void removeUserDefinedCommandFromStack(UserDefinedCommand userDefinedCommand){
        userDefinedCommandStack.remove(userDefinedCommand);
    }

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

    public Optional<ImmutableUserDefinedCommand> getUserDefinedCommand(String commandName){
        if (userDefinedCommands.containsKey(commandName)){
            return Optional.of(userDefinedCommands.get(commandName));
        }
        return Optional.empty();
    }

    public Set<String> getAllCommands() {
        return userDefinedCommands.keySet();
    }

    public Set<String> getAllVariables() {
        return availableVariables.keySet();
    }

    public String getCommandLanguage(){
         return commandLanguage;
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
    public Collection<Turtle> getImmutableTurtles(){
        return Collections.unmodifiableCollection(myTurtles);
    }

    public void showMessage(String string){
        frontendController.consoleShowError(string);
    }

    public void setFrontendController(FrontendController frontendController) {
        this.frontendController = frontendController;
    }

    public void parseAndRun(String userInput){
        ParseCommand parser = new ParseCommand(userInput, myTurtles, commandLanguage, this);
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