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
//    double xLeftCorner = 0;
//    double yLeftCorner = 0;

    public BackendController(){
//        setLanguage("English");
        myGrid = new Grid(400,400);
        myTurtles.add(new Turtle(myGrid));
        Turtle turtle2 = new Turtle(myGrid);
        turtle2.move(50);
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
        parser = new ParseCommand(userInput, myTurtles);
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
