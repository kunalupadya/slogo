package Parser.Commands.Turtle_Command;

public class EqualCommand extends BooleanCommand {

    public EqualCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() ==  myChildrenList.get(1).getReturnValue());
    }

}