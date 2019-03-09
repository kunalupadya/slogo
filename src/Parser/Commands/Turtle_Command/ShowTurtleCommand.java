package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ShowTurtleCommand extends TurtleCommand {

    public ShowTurtleCommand(){
<<<<<<< HEAD
        setNumParameters(0);
=======
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 0;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
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