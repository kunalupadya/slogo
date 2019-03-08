package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.Variable;

/**
 * @author kunalupadya
 */
public class MakeVariableCommand extends Command {
    public MakeVariableCommand(){
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        String name = getChildren().get(0).getText();
        Command variable = getChildren().get(0);
        setReturnValue(getChildren().get(1).getReturnValue());
        variable.setReturnValue(getReturnValue());
        if (variable.getClass() == Variable.class){
            backendController.addOrReplaceVariable(name, (Variable) getChildren().get(0));
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
