package Backend.SLogoExpressions;

import Backend.Variable;

public class GroupExpr extends SeriesInputExpr{

    public GroupExpr(String input){
        super(input, "Group");
    }

    @Override
    public Variable evaluate() {
        return null;
    }
}
