package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class SetPaletteCommand extends TurtleCommand {

    public static final int INDEX = 0;
    public static final int R_VALUE = 1;
    public static final int G_VALUE = 2;
    public static final int B_VALUE = 3;

    public SetPaletteCommand(){
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 4;
    }

    @Override
    protected void performAction(BackendController backendController){

        int index = (int) getChildren().get(INDEX).getReturnValue();
        int r = (int) getChildren().get(R_VALUE).getReturnValue();
        int g = (int) getChildren().get(G_VALUE).getReturnValue();
        int b = (int) getChildren().get(B_VALUE).getReturnValue();
        backendController.setMyPalette(index, Color.rgb(r,g,b));
        returnValue = index;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
    }

    @Override
    public Command copy() {
        return new SetPaletteCommand();
    }
}
