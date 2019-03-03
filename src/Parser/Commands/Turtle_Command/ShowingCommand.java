package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ShowingCommand extends TurtleCommand {

    public ShowingCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        getTurtle().setTurtleVisibility(true);
    }
}
