package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class HeadingCommand extends TurtleCommand {

    public HeadingCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        returnValue = myTurtle.getMyAngle();

    }
}
