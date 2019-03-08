package Parser.Commands;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;

public abstract class TurtleCommand extends Command{

    protected void performAction(BackendController backendController){
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    protected abstract void turtleAction(Turtle turtle);

    protected double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getMyX() - point2.getMyX(), 2) + Math.pow(point1.getMyY() - point2.getMyY(), 2));
    }
}
