package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

/**
 * @author kunalupadya
 */
public class MinusCommand extends Command {

    public MinusCommand(){
        setNumParameters(1);
    }

    public void performAction(BackendController backendController){
        setReturnValue(-getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new MinusCommand();
    }
}
