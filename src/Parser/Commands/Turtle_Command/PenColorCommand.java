package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class PenColorCommand extends TurtleCommand {

    public PenColorCommand(){
        isConstant = false;
        numParameters = 0;
    }


    @Override
    protected void turtleAction(Turtle turtle) {
    //        returnValue = getTurtle().getMyPen().getPenColor();
    }

    @Override
    public Command copy() {
        return new PenColorCommand();
    }
}

