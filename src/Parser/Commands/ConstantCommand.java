package Parser.Commands;

public class ConstantCommand extends Command {

    public ConstantCommand(){
        isConstant = true;
        numParameters = 1;
    }

    public void execute(){
        returnValue =  (int) myChildrenList.get(0).getReturnValue();
    }

}
