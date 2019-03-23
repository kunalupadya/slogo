package Parser.Commands;

import Parser.BackendController;
import Parser.SLogoException;

/**
 * This abstract class is for all sub command classes that do not require a turtle to execute.
 *
 * @author kunalupadya
 */
public abstract class BasicCommand extends Command{

    /**
     * Evaluates command.
     *
     * @param backendController backendController
     * @throws SLogoException exception that may occur in evaluation
     */
    public void execute(BackendController backendController) throws SLogoException {
        performAction(backendController);
        setIsEvaluated(true);
    }

    protected abstract void performAction(BackendController backendController) throws SLogoException;
}