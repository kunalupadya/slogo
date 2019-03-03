package Parser.Commands.Turtle_Command;

public class AndCommand extends Parser.Commands.Turtle_Command.Boolean.BooleanCommand {

    public AndCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(){
        returnValue =  returnValue(myChildrenList.get(0).getReturnValue() !=0 && myChildrenList.get(1).getReturnValue() !=0);
    }

}
