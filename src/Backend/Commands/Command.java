package Backend.Commands;

import Backend.InputController;
import Backend.InternalController;
import Backend.SLogoExpressions.Expression;
import Backend.Variable;

import java.util.List;

public class Command extends Expression {

    public Command(String name, InternalController controller){
        super(name, controller, 0);
    }


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

    @Override
    public Variable evaluate() {
        return new Variable(run());
    }

    //method to be overriden by every command
    public double run(){
        return 0;
    }

    public void addChildrenList(List<Command> childrenList){
        myChildrenList = childrenList;
    }
}
