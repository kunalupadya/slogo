package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class ShapeCommand extends TurtleCommand {

    public ShapeCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
       returnValue = getTurtle().getMyShape();
    }
}
