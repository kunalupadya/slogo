package Main;


import GUI.WindowLayout;
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
    WindowLayout windowLayout;

    public BackendController(){
//        setLanguage("English");
        myGrid = new Grid(400,400);
        myTurtles.add(new Turtle(myGrid));
        System.out.println("myTurtlelist size " + myTurtles.size() );
    }

    public String getCommanLanguage(){
         return commmandLanguage;
    }

    public void setCommmandLanguage(String language){
        commmandLanguage = language;

    }

    public Grid getMyGrid() {
        return myGrid;
    }

    public List<Turtle> getMyTurtles() {
        return myTurtles;
    }

    public void showMessage(String string){
        windowLayout.consoleShowError(string);
    }

    public void setWindowLayout(WindowLayout windowLayout) {
        this.windowLayout = windowLayout;
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
