package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 */
public class HeadingCommand extends TurtleCommand {

    public HeadingCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        setReturnValue(turtle.getMyAngle() % 360);
    }

    @Override
    public Command copy() {
        return new HeadingCommand();
    }
}
