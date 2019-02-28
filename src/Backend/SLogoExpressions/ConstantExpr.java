package Backend.SLogoExpressions;

import Backend.InternalController;
import Backend.Variable;

public class ConstantExpr extends Expression {

    public ConstantExpr(String input, InternalController controller){
        super(input, controller, 0);
    }

    @Override
    public Variable evaluate() {
        return new Variable(Double.parseDouble(getInfo()));
    }
}
