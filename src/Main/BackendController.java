package Main;


import GUI.WindowLayout;
import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.ParseCommand;

import java.util.ArrayList;
import java.util.List;

public class BackendController {

    private ParseCommand parser;
    String codeLanguage;
    Grid myGrid;
    List<Turtle> myTurtles = new ArrayList<>();
    WindowLayout windowLayout;

    public BackendController(){
//        setLanguage("English");
        myGrid = new Grid(400,400);
        Turtle turtle1 = new Turtle(myGrid);
        myTurtles.add(turtle1);
        Turtle turtle2 = new Turtle(myGrid);
        turtle2.turn(20);
        turtle2.move(10000);
        turtle2.move(300);
        myTurtles.add(turtle2);

    }

    public Grid getMyGrid() {
        return myGrid;
    }

    public List<Turtle> getMyTurtles() {
        return myTurtles;
    }

    public void setWindowLayout(WindowLayout windowLayout) {
        this.windowLayout = windowLayout;
    }

    public void parseAndRun(String userInput){
        parser = new ParseCommand(userInput, myTurtles,this);
    }

//    private void executeCommandTree(Expression rootExpr) {
//    }
//
//    public String getCodeLanguage(){
//        return codeLanguage;
//    }
//
//    public ParseCommand getParser(){
//        return parser;
//    }
}
