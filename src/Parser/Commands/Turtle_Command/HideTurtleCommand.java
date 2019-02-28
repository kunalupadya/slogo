package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class HideTurtleCommand extends TurtleCommand {

    public HideTurtleCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void execute() {
        getTurtle().makeTurtleInvisible();
        returnValue = 0;

    }
}
