package Parser.Commands.Turtle_Command;


import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ForwardCommand extends TurtleCommand {

    public ForwardCommand(){
        setNumParameters(1);
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.move(getChildren().get(0).getReturnValue());
        setReturnValue(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new ForwardCommand();
    }
}
