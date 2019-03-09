package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class AskWithCommand extends TurtleCommand {

    public AskWithCommand(){
        isOutputCommand = false;
        setNumParameters(2);
    }

    @Override
    protected void turtleAction(Turtle turtle) {

    }

    @Override
    public Command copy() {
        return new AskWithCommand();
    }
}
