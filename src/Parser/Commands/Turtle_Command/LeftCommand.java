package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;

public class LeftCommand extends TurtleCommand {

    public LeftCommand() {
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws ExecutionException{
        if (getChildren().get(0).getReturnValue() < 0){
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        turtle.turn(-getChildren().get(0).getReturnValue());
        setReturnValue(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new LeftCommand();
    }
}
