package Parser.Commands.Turtle_Command;

public class NotCommand extends BooleanCommand{

    public NotCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() ==0);
    }

}
