package Parser.Commands;

import Parser.BackendController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kunalupadya
 */
public abstract class Command{

    private List<Command> myChildrenList = new ArrayList<>();
    private boolean isEvaluated = false;
    private double returnValue;
    private String text;
    private int numParameters;
    private int currentNumParameters = 0;

    public int getCurrentNumParameters() {
        return currentNumParameters;
    }

    public boolean getIsEvaluated(){
        return isEvaluated;
    }

    public void setIsEvaluated(boolean constant) {
        isEvaluated = constant;
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

    protected void setText(String text) {
        this.text = text;
    }

    public void execute(BackendController backendController) {
        performAction(backendController);
        isEvaluated = true;
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