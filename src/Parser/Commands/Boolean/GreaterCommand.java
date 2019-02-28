package Parser.Commands.Boolean;

public class GreaterCommand extends BooleanCommand {

    public GreaterCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void execute(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() > myChildrenList.get(1).getReturnValue());
    }

}
