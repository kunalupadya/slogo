package Parser.Commands.Turtle_Command.Boolean;

public class GreaterCommand extends Parser.Commands.Turtle_Command.Boolean.BooleanCommand {

    public GreaterCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() > myChildrenList.get(1).getReturnValue());
    }

}
