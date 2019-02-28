package Parser.Commands;

import java.util.List;

public abstract class Command{

    protected List<Command> myChildrenList;

    protected double returnValue;

    protected abstract boolean isConstant();

    public abstract int getNumParameters();

    public abstract double execute();

    public void addChildren(Command command) {
        myChildrenList.add(command);
    }

    public List<Command> getChildren(){
        return myChildrenList;
    }

    public void addChildrenList(List<Command> childrenList){
        myChildrenList = childrenList;
    }
}
