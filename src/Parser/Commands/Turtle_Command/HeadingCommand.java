package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class HeadingCommand extends Command {

    public HeadingCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getMyAngle() % 360);
    }

    @Override
    public Command copy() {
        return new HeadingCommand();
    }
}
