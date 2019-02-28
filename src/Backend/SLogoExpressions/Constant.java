package Backend.SLogoExpressions;

import Backend.Variable;

public class Constant extends Expression{

    public Constant(String input){
        super(input);

    }

    @Override
    public Variable evaluate() {
        return new Variable(Double.parseDouble(getInfo()));
    }
}
