package Parser.Commands;

import Parser.BackendController;

import java.util.ArrayList;
import java.util.List;

public abstract class Command{

    protected List<Command> myChildrenList = new ArrayList<>();
    protected boolean isConstant;
    protected double returnValue;
    protected String text;
    protected int numParameters;
    private int currentNumParameters = 0;


    public int getCurrentNumParameters() {
        return currentNumParameters;
    }

    public boolean getIsConstant(){
        return isConstant;
    }

    public void setIsConstant(boolean constant) {
        isConstant = constant;
    }

    public int getNumParameters(){
        return numParameters;
    }

    public void setNumParameters(int numParameters) {
        this.numParameters = numParameters;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(double returnValue) {
        this.returnValue = returnValue;
    }

    public String getText() {
        return text;
    }

    public void execute(BackendController backendController) {
        performAction(backendController);
        System.out.println(returnValue);
        isConstant = true;
    }

    protected abstract void performAction(BackendController backendController);

    public abstract Command copy();

    public void addChildren(Command command) {
//        if (command != this) {
            myChildrenList.add(command);
            currentNumParameters += 1;
//        }
    }

    public List<Command> getChildren(){
        return myChildrenList;
    }
}