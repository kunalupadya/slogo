package Parser.Commands.Turtle_Command;


import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ForwardCommand extends TurtleCommand {

    public ForwardCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        getTurtle().move(getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }
}
