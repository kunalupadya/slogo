package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class HideTurtleCommand extends TurtleCommand {

    public HideTurtleCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction() {
        getTurtle().setTurtleVisibility(false);
        returnValue = 0;

    }
}
