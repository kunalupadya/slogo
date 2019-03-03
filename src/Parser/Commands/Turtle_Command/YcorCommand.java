package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class YcorCommand extends TurtleCommand {

    public YcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        getTurtle().getyPos();
    }

}
