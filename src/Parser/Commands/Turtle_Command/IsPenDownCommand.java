package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class IsPenDownCommand extends Command {

    private static final int PEN_DOWN = 1;
    private static final int PEN_UP = 0;

    public IsPenDownCommand(){
        isOutputCommand = true;
        setNumParameters(0);
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getMyPen().getPenUp() ? PEN_UP : PEN_DOWN);
    }

    @Override
    public Command copy() {
        return new IsPenDownCommand();
    }
}
