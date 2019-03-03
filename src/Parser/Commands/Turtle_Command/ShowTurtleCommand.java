package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ShowTurtleCommand extends TurtleCommand {

    public ShowTurtleCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setTurtleVisibility(true);
        returnValue = 1;
    }
}