package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetPenColorCommand extends TurtleCommand {

    public SetPenColorCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
    //        (getTurtle().getMyPen().setPenColor(getChildren().get(0).getReturnValue() (int));
    }

}
