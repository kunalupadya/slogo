package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

import java.util.List;

public class MakeUserInstructionCommand extends Command {

//    List<Variable> variables

    public MakeUserInstructionCommand(){
        isConstant = false;
        numParameters = 3;
    }

    @Override
    protected void performAction(BackendController backendController) {
        String name = myChildrenList.get(0).getText();
        numParameters = (int) myChildrenList.get(1).getReturnValue();

    }
}
