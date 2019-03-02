package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetHeadingCommand extends TurtleCommand{

    public SetHeadingCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction() {
        getTurtle().turn(getChildren().get(0).getReturnValue());
        returnValue = Math.abs(getChildren().get(0).getReturnValue());

    }
}
