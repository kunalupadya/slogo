package Parser.Commands;

import Parser.BackendController;
import Parser.SLogoException;

/**
 * @author kunalupadya
 */

public abstract class BasicCommand extends Command{

    public void execute(BackendController backendController) throws SLogoException {
        performAction(backendController);
        setIsEvaluated(true);
    }

    protected abstract void performAction(BackendController backendController) throws SLogoException;
}