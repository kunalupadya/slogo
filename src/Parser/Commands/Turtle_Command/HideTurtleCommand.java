package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class HideTurtleCommand extends TurtleCommand {

    public HideTurtleCommand(){
        setNumParameters(0);
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setTurtleVisibility(false);
        setReturnValue(0);
    }

    @Override
    public Command copy() {
        return new HideTurtleCommand();
    }
}
