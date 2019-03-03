package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class XcorCommand extends TurtleCommand {

    public XcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        getTurtle().getxPos();
    }
}
