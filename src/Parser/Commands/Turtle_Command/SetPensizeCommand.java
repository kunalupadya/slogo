package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetPensizeCommand extends TurtleCommand {


    public SetPensizeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.getMyPen().setPenSize((int)getChildren().get(0).getReturnValue());
    }
}
