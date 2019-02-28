package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class PenDownCommand extends TurtleCommand {

    public PenDownCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void execute() {
        getTurtle().getMyPen().setPenUp(false);
        returnValue = 1;

    }
}
