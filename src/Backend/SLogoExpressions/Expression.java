package Backend.SLogoExpressions;

import Backend.Variable;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression {

    private List<Expression> children;
    private Expression parent;
    private String exprInfo;

    Expression(String input){
        exprInfo = input;
        children = new ArrayList<Expression>();

    }

    public String getInfo(){
        return exprInfo;
    }

    public void setInfo(String input){
        exprInfo = input;
    }

    public void addChild(Expression child){
        children.add(child);
    }

    public int getChildrenSize(){
        return children.size();
    }

    public List<Expression> getChildren(){
        return children;
    }

    public Expression getParent() {
        return parent;
    }

    public abstract Variable evaluate();


}
