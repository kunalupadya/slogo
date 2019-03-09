package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetPositionCommand extends TurtleCommand{

    public SetPositionCommand(){
<<<<<<< HEAD
        setIsEvaluated(false);
        setNumParameters(2);
=======
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 2;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        Point newPos =  new Point(getChildren().get(0).getReturnValue(), getChildren().get(1).getReturnValue());
        setReturnValue(distance(turtle.getPos(),newPos));
        turtle.moveTo(newPos);
    }

    @Override
    public Command copy() {
        return new SetPositionCommand();
    }
}
