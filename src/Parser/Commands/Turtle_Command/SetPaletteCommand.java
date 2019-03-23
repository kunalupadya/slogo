package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import javafx.scene.paint.Color;

/**
 * Command sets color corresponding at given index param to given r g b color param values.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SetPaletteCommand extends BasicCommand {

    private static final int INDEX = 0;
    private static final int R_VALUE = 1;
    private static final int G_VALUE = 2;
    private static final int B_VALUE = 3;

    /**
     * Command Constructor
     */
    public SetPaletteCommand(){
        setNumParameters(4);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        int index = (int) getChildren().get(INDEX).getReturnValue() - 1;
        int r = (int) getChildren().get(R_VALUE).getReturnValue();
        int g = (int) getChildren().get(G_VALUE).getReturnValue();
        int b = (int) getChildren().get(B_VALUE).getReturnValue();
        backendController.addColorToPalette(index, Color.rgb(r, g, b));
        setReturnValue(index);
    }

}
