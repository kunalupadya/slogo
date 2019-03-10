package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class MinusCommand extends Command {

    public MinusCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(-getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new MinusCommand();
    }
}
