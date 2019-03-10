package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import javafx.scene.paint.Color;

public class GetPenColorCommand extends Command {

    private Color myColor;

    public GetPenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(backendController.getColorPaletteIndex(turtle.getMyPen().getMyPenColor()));
    }

    @Override
    public Command copy() {
        return new GetPenColorCommand();
    }


}

