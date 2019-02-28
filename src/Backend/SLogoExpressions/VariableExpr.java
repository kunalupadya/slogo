package Backend.SLogoExpressions;

import Backend.InternalController;
import Backend.Variable;

public class VariableExpr extends Expression {

    public VariableExpr(String input, InternalController controller){
        super(input, controller);
    }

    @Override
    //TODO: needs implementation
    public Variable evaluate() {
        //check for variable in our table of user-created variables
        //or check if this expression was used in make/set variable, dotimes, for, or TO commands
        //or display error on console
        return null;
    }

}
