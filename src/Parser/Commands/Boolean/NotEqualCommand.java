package Parser.Commands.Boolean;

public class NotEqualCommand extends BooleanCommand{

    public NotEqualCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() !=0);
    }

}
