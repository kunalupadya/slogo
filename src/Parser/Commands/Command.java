package Parser.Commands;

import java.util.List;

public abstract class Command{

    protected List<Command> myChildrenList;
    protected boolean isConstant;
    protected double returnValue;

    public abstract boolean getIsConstant();

    public abstract int getNumParameters();

    public abstract double execute();

    public void addChildren(Command command) {
        myChildrenList.add(command);
    }

    public List<Command> getChildren(){
        return myChildrenList;
    }
}
