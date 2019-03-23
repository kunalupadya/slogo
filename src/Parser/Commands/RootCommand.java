package Parser.Commands;

import Parser.BackendController;

/**
 * This class represents that root of the parsing tree. Its children are all the commands to be evaluated.
 *
 * @author kunalupadya
 */
public class RootCommand extends BasicCommand{

    /**
     * Root Command Constructor
     */
    public RootCommand(){
        setNumParameters((int) Double.POSITIVE_INFINITY);
        isOutputCommand = false;
    }

    /**
     * RootCommand does not evaluate to anything.
     *
     * @param backendController backendController
     */
    @Override
    public void performAction(BackendController backendController) {
    }

}
