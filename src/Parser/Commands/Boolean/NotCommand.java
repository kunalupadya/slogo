package Parser.Commands.Boolean;

public class NotCommand extends BooleanCommand{

    public NotCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void execute(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() ==0);
    }

}
