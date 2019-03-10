package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class PenColorCommand extends Command {

    public PenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(backendController.getColorPaletteIndex(turtle.getMyPen().getMyPenColor()));
    }

    @Override
    public Command copy() {
        return new PenColorCommand();
    }

}

