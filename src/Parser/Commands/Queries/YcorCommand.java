package Parser.Commands.Queries;

import Parser.Commands.TurtleCommand;

public class YcorCommand extends TurtleCommand {

    public YcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void execute(){
        getTurtle().getyPos();
    }

}
