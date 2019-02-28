package Parser.Commands;

import java.util.List;

public abstract class Command{

    protected List<Command> myChildrenList;

    public int getNumParameters(){
        return 0;
    }

    public double execute(){
        return 0;
    }

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
