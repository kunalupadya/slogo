package Parser.Commands;

import GraphicsBackend.Turtle;

import java.util.ArrayList;
import java.util.List;

public abstract class Command{




    //in constructor, need to set isConstant, numparameters
    protected List<Command> myChildrenList = new ArrayList<>();
    protected boolean isConstant;
    protected double returnValue;
    protected int numParameters;
    protected int currentNumParameters = 0;
    protected List<Turtle> myTurtleList;

    public void setMyTurtleList(List<Turtle> turtleList){myTurtleList = turtleList;}

    public int getMyTurtleListSize(){return myTurtleList.size();}

    public int getCurrentNumParameters() {
        return currentNumParameters;
    }

    public boolean getIsConstant(){
        return isConstant;
    }

    public  int getNumParameters(){
        return numParameters;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public void execute() {
        performAction();
        isConstant = true;
    }

    public abstract void performAction();

    public void addChildren(Command command) {
        myChildrenList.add(command);
        currentNumParameters += 1;
    }

    public List<Command> getChildren(){
        return myChildrenList;
    }
}