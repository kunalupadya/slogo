package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import Parser.ExecutionException;
import Parser.SLogoException;
import javafx.scene.paint.Color;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class SetPenColorCommand extends TurtleCommand {

    public SetPenColorCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) throws SLogoException {
        int index = (int) getChildren().get(0).getReturnValue();
        if (index < 1){
            throw new ExecutionException("Palette contains indices starting from 1");
        }
        if (index > findPaletteLength(backendController)){
            throw new ExecutionException("Color index does not exist in Palette");
        }
        setReturnValue(getChildren().get(0).getReturnValue());
        turtle.setPenColor(backendController.getColor((int) getReturnValue() - 1));
    }

    private int findPaletteLength(BackendController backendController){
        int length = 0;
        Color [] palette = backendController.getColorPalette();
        for (Color color: palette){
            if (color != null){
                length++;
            }
            else{
                break;
            }
        }
        return length;
    }

    @Override
    public Command copy() {
        return new SetPenColorCommand();
    }
}
