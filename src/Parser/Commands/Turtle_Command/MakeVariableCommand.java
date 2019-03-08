package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.Variable;

/**
 * @author kunalupadya
 */
public class MakeVariableCommand extends Command {
    public MakeVariableCommand(){
        isEvaluated = false;
        numParameters = 2;
    }

    @Override
    protected void performAction(BackendController backendController) {
        String name = myChildrenList.get(0).getText();
        Command variable = myChildrenList.get(0);
        returnValue = myChildrenList.get(1).getReturnValue();
        variable.setReturnValue(returnValue);
        if (variable.getClass() == Variable.class){
            backendController.addOrReplaceVariable(name, (Variable) myChildrenList.get(0));
        }
        else{
            //throw new TODO create an exception here to represent inputting something other than a variable as the first param
        }
    }

    @Override
    public Command copy() {
        return new MakeVariableCommand();
    }
}
