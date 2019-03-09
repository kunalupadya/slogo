package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class RootCommand extends Command{

    public RootCommand(){
<<<<<<< HEAD
        setIsEvaluated(false);
        setNumParameters((int) Double.POSITIVE_INFINITY);
=======
        isEvaluated = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
        isOutputCommand = false;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    public void performAction(BackendController backendController){
    }

    @Override
    public Command copy() {
        return new RootCommand();
    }
}
