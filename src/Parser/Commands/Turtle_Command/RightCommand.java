package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class RightCommand extends TurtleCommand {

    public RightCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.turn(getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }

    @Override
    public Command copy() {
        return new RightCommand();
    }
}
