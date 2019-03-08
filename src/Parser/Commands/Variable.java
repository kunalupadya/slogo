package Parser.Commands;

import Parser.BackendController;

import java.util.Optional;

public class Variable extends Command{
    public Variable(String text){
        setIsEvaluated(false);
        setNumParameters(0);
        setText(text);
    }

    @Override
    protected void performAction(BackendController backendController) {
        Optional<Double> variableValue= backendController.getVariableIfExists(getText());

        if (variableValue.isPresent()){
            setReturnValue(variableValue.get());
            setIsEvaluated(false);
        }
        else{
            //throw new TODO make an exception for not having defined the variable
        }
    }

    @Override
    public Command copy() {
        return new Variable(getText());
    }
}
