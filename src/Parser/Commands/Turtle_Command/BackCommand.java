package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class BackCommand extends TurtleCommand {

    public BackCommand(){
        isConstant = false;
        numParameters = 1;
    }

    protected void turtleAction(Turtle turtle){
        turtle.move(-getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }
}
