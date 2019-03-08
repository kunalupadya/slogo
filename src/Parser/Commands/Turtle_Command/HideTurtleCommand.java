package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class HideTurtleCommand extends TurtleCommand {

    public HideTurtleCommand(){
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setTurtleVisibility(false);
        returnValue = 0;
    }

    @Override
    public Command copy() {
        return new HideTurtleCommand();
    }
}
