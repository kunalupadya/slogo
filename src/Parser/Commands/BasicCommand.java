package Parser.Commands;

import Parser.BackendController;

public abstract class BasicCommand extends Command{

    public void execute(BackendController backendController) {
        performAction(backendController);
        setIsEvaluated(true);
    }

    protected abstract void performAction(BackendController backendController);
}
