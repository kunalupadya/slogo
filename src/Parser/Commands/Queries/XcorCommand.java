package Parser.Commands.Queries;

import Parser.Commands.TurtleCommand;

public class XcorCommand extends TurtleCommand {

    public XcorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void execute(){
        getTurtle().getxPos();
    }
}
