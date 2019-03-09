package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class RootCommand extends Command{

    public RootCommand(){
        isEvaluated = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
        isOutputCommand = false;
    }

    public void performAction(BackendController backendController){
    }

    @Override
    public Command copy() {
        return new RootCommand();
    }
}
