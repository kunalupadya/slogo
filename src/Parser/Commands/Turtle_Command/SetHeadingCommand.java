package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetHeadingCommand extends TurtleCommand{

    public SetHeadingCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.turnTo(getChildren().get(0).getReturnValue());
        returnValue = Math.abs(getChildren().get(0).getReturnValue());
    }
}
