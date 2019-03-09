package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetShapeCommand extends TurtleCommand {

    public SetShapeCommand(){
<<<<<<< HEAD
        setIsEvaluated(false);
        setNumParameters(1);
=======
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 1;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    @Override
    protected void turtleAction(Turtle turtle){
       turtle.setMyShape((int)getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SetShapeCommand();
    }
}
