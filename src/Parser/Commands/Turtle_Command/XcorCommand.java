package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class XcorCommand extends TurtleCommand {

    public XcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue =turtle.getxPos();
    }

    @Override
    public Command copy() {
        return new XcorCommand();
    }
}
