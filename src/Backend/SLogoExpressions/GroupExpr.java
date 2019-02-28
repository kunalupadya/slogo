package Backend.SLogoExpressions;

import Backend.InternalController;
import Backend.Variable;

public class GroupExpr extends SeriesInputExpr{

    public GroupExpr(String input, InternalController controller){
        super(input, "Group", controller);
    }

    @Override
    public Variable evaluate() {
        return null;
    }
}
