package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class LeftCommand extends TurtleCommand {


    public LeftCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        getTurtle().turn(-getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }


}
