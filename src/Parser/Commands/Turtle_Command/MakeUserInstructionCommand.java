package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeUserInstructionCommand extends Command {

    private List< Variable> variables = new ArrayList<>();

    public MakeUserInstructionCommand(){
        isConstant = false;
        numParameters = 3;
    }

    @Override
    protected void performAction(BackendController backendController) {
        String name = myChildrenList.get(0).getText();
        for (Command variable: myChildrenList.get(1).getChildren()) {
            if (variable.getClass() == Variable.class) {
                variables.add((Variable) variable);
            }
            else{
                returnValue = 0;
                // TODO throw new exception, not a variable parameter
            }
        }
        backendController.addNewUserDefinedCommand(name, this);
        returnValue = 1;
    }

    public List<Variable> getVariables() {
        return variables;
    }
}
