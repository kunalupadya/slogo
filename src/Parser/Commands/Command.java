package Parser.Commands;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
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
    protected boolean isOutputCommand;

    public boolean getIsOutputCommand(){
        return isOutputCommand;
    }

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
        isEvaluated = true;
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    public abstract Command copy();

    public void addChildren(Command command) {
            myChildrenList.add(command);
            currentNumParameters += 1;
    }

    public List<Command> getChildren(){
        return myChildrenList;
    }

    protected double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getMyX() - point2.getMyX(), 2) + Math.pow(point1.getMyY() - point2.getMyY(), 2));
    }
}