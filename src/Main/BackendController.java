package Main;


import GUI.FrontendController;
import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.Commands.Turtle_Command.MakeUserInstructionCommand;
import Parser.Commands.Variable;
import Parser.ParseCommand;
import javafx.scene.paint.Color;

import java.util.*;

public class BackendController {


    private String commmandLanguage;
    private Grid myGrid;
    private List<Turtle> myTurtles = new ArrayList<>();
    private Map<String, MakeUserInstructionCommand> userDefinedCommands;
    private Map<String, Variable> availableVariables;
    private Color[] myColorPalette;
    private FrontendController frontendController;

    public BackendController(){
        myGrid = new Grid(400,400);
        userDefinedCommands = new HashMap<>();
        availableVariables = new HashMap<>();
        myColorPalette = new Color[256];
        myTurtles.add(new Turtle(myGrid));
        Turtle turtle2 = new Turtle(myGrid);
        turtle2.turn(20);
        turtle2.move(50);
        turtle2.turn(300);
        turtle2.move(100);
        myTurtles.add(turtle2);
    }

    public void addNewUserDefinedCommand(String commandName, MakeUserInstructionCommand tree){
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

    public Optional<MakeUserInstructionCommand> getUserDefinedCommand(String commandName){
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
        frontendController.consoleShowError(string);
    }

    public void setFrontendController(FrontendController frontendController) {
        this.frontendController = frontendController;
    }

    public void parseAndRun(String userInput){
        ParseCommand parser = new ParseCommand(userInput, myTurtles, commmandLanguage, this);
    }

    public Color getColorPalette(int index){
        return myColorPalette[index];
    }

    public void setMyPalette(int index, Color color){
        myColorPalette[index] = color;
    }

}

//    private void executeCommandTree(Expression rootExpr) {
//    }
//    public ParseCommand getParser(){
//        return parser;
//    }

