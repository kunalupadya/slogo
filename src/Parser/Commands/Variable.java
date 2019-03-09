package Parser.Commands;

import Parser.BackendController;

import java.util.Optional;

public class Variable extends Command{
    public Variable(String text){
<<<<<<< HEAD
        setIsEvaluated(false);
        setNumParameters(0);
        setText(text);
=======
        isEvaluated = false;
        numParameters = 0;
        this.text = text;
        isOutputCommand = true;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
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
