package Backend.SLogoExpressions;

import Backend.InternalController;
import Backend.Variable;

public class ListExpr extends SeriesInputExpr{

    public ListExpr(String input, InternalController controller){
        super(input, "List", controller);
    }

    public ListExpr(InternalController controller){
        this(null, controller);
    }

    @Override
    public Variable evaluate() {
        return null;
    }
}
