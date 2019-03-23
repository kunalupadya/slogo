package Parser.Commands;

import Parser.BackendController;
import Parser.ExecutionException;
import Parser.SLogoException;

import java.util.Optional;

public class Variable extends BasicCommand{
    public Variable(String text){
        setNumParameters(0);
        setText(text);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        Optional<Double> variableValue= backendController.getVariableIfExists(getText());
        if (variableValue.isPresent()){
            setReturnValue(variableValue.get());
        }
        else{
            throw new ExecutionException(getText() + " has not been defined");
        }
    }

    @Override
    public Command copy() {
        return new Variable(getText());
    }
}
