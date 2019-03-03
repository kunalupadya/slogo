package Parser.Commands;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Main.BackendController;

import java.util.List;

public abstract class TurtleCommand extends Command{

    protected List<Turtle> turtleList;
    protected Turtle myTurtle;

//    protected Turtle getTurtle(){
//        return turtleList.get(0);
//    }
    protected void performAction(BackendController backendController){
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction();
            }
        }
    }

    protected abstract void turtleAction();
//    protected List<Turtle> getTurtleList(){
//        return turtleList;
//    }

//    protected Point endLocation(double parameters, Turtle turtle) {
//        double rad = Math.toRadians(turtle.getMyAngle());
//        double x = (Math.cos(rad) * parameters);
//        double y = (Math.sin(rad) * parameters);
//        return new Point(turtle.getxPos() + x, turtle.getyPos() + y);
//    }

    protected double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getMyX() - point2.getMyX(), 2) + Math.pow(point1.getMyY() - point2.getMyY(), 2));
    }

}
