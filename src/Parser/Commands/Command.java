package Parser.Commands;

import java.util.List;

public abstract class Command{

    protected List<Command> myChildrenList;
    protected boolean isConstant;
    protected double returnValue;
    protected int numParameters;

    public boolean getIsConstant(){
        return isConstant;
    }

    public  int getNumParameters(){
        return numParameters;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public abstract double execute();

    public void addChildren(Command command) {
        myChildrenList.add(command);
    }

    public List<Command> getChildren(){
        return myChildrenList;
    }
}
