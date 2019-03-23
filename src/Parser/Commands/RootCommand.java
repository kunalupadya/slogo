package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class RootCommand extends BasicCommand{

    public RootCommand(){
        setNumParameters((int) Double.POSITIVE_INFINITY);
        isOutputCommand = false;
    }

    @Override
    public void performAction(BackendController backendController) {
    }

}
