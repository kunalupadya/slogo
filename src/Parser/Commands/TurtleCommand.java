package Parser.Commands;

import GraphicsBackend.Turtle;
import Parser.BackendController;

public abstract class TurtleCommand extends Command{

    protected boolean turtleQuery = false;

    public void execute(BackendController backendController, Turtle currTurtle) {
        performAction(backendController, currTurtle);
        setIsEvaluated(true);
    }

    public boolean isTurtleQuery(){
        return turtleQuery;
    }

    protected abstract void performAction(BackendController backendController, Turtle turtle);
}
