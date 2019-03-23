package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.ExecutionException;
import Parser.SLogoException;
import javafx.scene.paint.Color;

/**
 * Command sets background color of screen to that represented by index param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class SetBackgroundCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public SetBackgroundCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        int index = (int) getChildren().get(0).getReturnValue();
        if (index < 1){
            throw new ExecutionException("Palette contains indices starting from 1");
        }
        if (index > findPaletteLength(backendController)){
            throw new ExecutionException("Color index does not exist in Palette");
        }
        setReturnValue(getChildren().get(0).getReturnValue());
        backendController.setBackGroundColor(backendController.getColor(index - 1));
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

}
