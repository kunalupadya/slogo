package Main;


import GUI.FrontendController;
import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.ParseCommand;

import java.util.ArrayList;
import java.util.List;

public class BackendController {

    private ParseCommand parser;
    String commmandLanguage;
    Grid myGrid;
    List<Turtle> myTurtles = new ArrayList<>();
    FrontendController frontendController;

    public BackendController(){

        myGrid = new Grid(400,400);
        myTurtles.add(new Turtle(myGrid));
        Turtle turtle2 = new Turtle(myGrid);
        turtle2.turn(20);
        turtle2.move(50);
        turtle2.turn(300);
        turtle2.move(100);
        myTurtles.add(turtle2);
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
        parser = new ParseCommand(userInput, myTurtles, commmandLanguage, this);

    }

//    private void executeCommandTree(Expression rootExpr) {
//    }
//    public ParseCommand getParser(){
//        return parser;
//    }
}
