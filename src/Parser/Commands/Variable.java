package Parser.Commands;

import Parser.BackendController;

import java.util.Optional;

public class Variable extends Command{
    public Variable(String text){
        isConstant = false;
        numParameters = 0;
        this.text = text;
    }

    @Override
    protected void performAction(BackendController backendController) {
        Optional<Double> variableValue= backendController.getVariableIfExists(text);

        if (variableValue.isPresent()){
            returnValue = variableValue.get();
            isConstant = true;
        }
        else{
            //throw new TODO make an exception for not having defined the variable
        }
    }

    @Override
    public Command copy() {
        return new Variable(text);
    }
}
