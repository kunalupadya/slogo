package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class BackwardCommand extends TurtleCommand {

    public BackwardCommand(){
        isEvaluated = false;
        numParameters = 1;
    }

    protected void turtleAction(Turtle turtle){
        turtle.move(-getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }

    @Override
    public Command copy() {
        return new BackwardCommand();
    }
}
