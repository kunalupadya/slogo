package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;

public class SetPositionCommand extends TurtleCommand {

    public SetPositionCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws ExecutionException{
        if (getChildren().get(0).getReturnValue() < 0 || getChildren().get(1).getReturnValue() < 0){
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        Point newPos =  new Point(getChildren().get(0).getReturnValue(), getChildren().get(1).getReturnValue());
        setReturnValue(distance(turtle.getPos(),newPos));
        turtle.moveTo(newPos);
    }

    @Override
    public Command copy() {
        return new SetPositionCommand();
    }
}
