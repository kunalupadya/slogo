package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.Commands.Variable;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * Command assigns the value of expr to variable, creating the variable if necessary.
 *
 * @author kunalupadya
 * @author Dhanush Madabusi
 */
public class MakeVariableCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public MakeVariableCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        String name = getChildren().get(0).getText();
        Command variable = getChildren().get(0);
        setReturnValue(getChildren().get(1).getReturnValue());
        variable.setReturnValue(getReturnValue());
        if (variable.getClass() == Variable.class){
            backendController.addOrReplaceVariable(name, (Variable) getChildren().get(0));
        }
        else{
            throw new ExecutionException("First parameter is not a valid variable input");
        }
    }

}
