package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class GetPenColorCommand extends TurtleCommand {

    public GetPenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(backendController.getColorPaletteIndex(turtle.getMyPen().getMyPenColor()) + 1);
    }

    @Override
    public Command copy() {
        return new GetPenColorCommand();
    }


}

