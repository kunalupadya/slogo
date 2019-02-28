package Backend.SLogoExpressions;

import Backend.Variable;

public class ConstantExpr extends Expression {

    public ConstantExpr(String input){
        super(input);

    }

    @Override
    public Variable evaluate() {
        return new Variable(Double.parseDouble(getInfo()));
    }
}
