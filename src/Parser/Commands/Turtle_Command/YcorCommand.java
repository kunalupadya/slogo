package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class YcorCommand extends TurtleCommand {

    public YcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue =turtle.getyPos();
    }

    @Override
    public Command copy() {
        return new YcorCommand();
    }
}
