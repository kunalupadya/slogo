package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class RightCommand extends TurtleCommand {

    public RightCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        getTurtle().turn(getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }
}
