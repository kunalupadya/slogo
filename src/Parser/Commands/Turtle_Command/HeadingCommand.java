package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class HeadingCommand extends TurtleCommand {

    public HeadingCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = myTurtle.getMyAngle();
    }

    @Override
    public Command copy() {
        return new HeadingCommand();
    }
}
