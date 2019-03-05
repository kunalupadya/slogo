package Main;


import GUI.WindowLayout;
import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.Turtle_Command.ListStartCommand;
import Parser.Commands.Turtle_Command.MakeUserInstructionCommand;
import Parser.Commands.Turtle_Command.UserDefinedCommand;
import Parser.Commands.Variable;
import Parser.ParseCommand;

import java.util.*;

public class BackendController {

//    private ParseCommand parser;
    private String commmandLanguage;
    private Grid myGrid;
    private List<Turtle> myTurtles = new ArrayList<>();
    private WindowLayout windowLayout;
    private Map<String, UserDefinedCommand> userDefinedCommands;
    private Map<String, Variable> availableVariables;

    public BackendController(){
        myGrid = new Grid(400,400);
        userDefinedCommands = new HashMap<>();
        availableVariables = new HashMap<>();
        myTurtles.add(new Turtle(myGrid));
        Turtle turtle2 = new Turtle(myGrid);
        turtle2.turn(20);
        turtle2.move(50);
        turtle2.turn(300);
        turtle2.move(100);
        myTurtles.add(turtle2);
    }

    public void addNewUserDefinedCommand(String commandName, UserDefinedCommand tree){
        userDefinedCommands.put(commandName,tree);
    }

    public void addOrReplaceVariable(String variableName, Variable variable){
        availableVariables.put(variableName, variable);
    }

    public Optional<Double> getVariableIfExists(String variableName){
        if (availableVariables.containsKey(variableName)){
            Double returnValue = availableVariables.get(variableName).getReturnValue();
            return Optional.of(returnValue);
        }
        return Optional.empty();
    }

    public Optional<UserDefinedCommand> getUserDefinedCommand(String commandName){
        if (userDefinedCommands.containsKey(commandName)){
            return Optional.of(userDefinedCommands.get(commandName));
        }
        return Optional.empty();
    }

    public String getCommandLanguage(){
         return commmandLanguage;
    }

    public void setCommandLanguage(String language){
        commmandLanguage = language;
    }

    public Grid getMyGrid() {
        return myGrid;
    }

    public List<Turtle> getMyTurtles() {
        return myTurtles;
    }

    public void showMessage(String string){
        System.out.println(string);
        windowLayout.consoleShowError(string);
    }

    public void setWindowLayout(WindowLayout windowLayout) {
        this.windowLayout = windowLayout;
    }

    public void parseAndRun(String userInput){
        ParseCommand parser = new ParseCommand(userInput, myTurtles, commmandLanguage, this);
        System.out.println("hi");
    }
}
