package Parser.Commands;

import GraphicsBackend.Turtle;
import Parser.BackendController;

public abstract class TurtleCommand extends Command{

    public void execute(BackendController backendController, Turtle currTurtle) {
        performAction(backendController, currTurtle);
        isEvaluated = true;
    }

    protected abstract void performAction(BackendController backendController, Turtle turtle);
}
