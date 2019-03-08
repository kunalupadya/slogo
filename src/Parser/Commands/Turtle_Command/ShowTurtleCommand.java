package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ShowTurtleCommand extends TurtleCommand {

    public ShowTurtleCommand(){
        setNumParameters(0);
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setTurtleVisibility(true);
        setReturnValue(1);
    }

    @Override
    public Command copy() {
        return new ShowTurtleCommand();
    }
}