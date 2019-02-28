package Backend.SLogoExpressions;

import Backend.InternalController;
import Backend.Variable;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression {

    private InternalController controller;
    private int numArgs;
    private List<Expression> children;
    private Expression parent;
    private String exprInfo;

    public Expression(String input, InternalController controller, int numArgs){
        this(input, controller);
        this.numArgs = numArgs;

    }

    public Expression(String input, InternalController controller) {
        exprInfo = input;
        this.controller = controller;

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

    public void setParent(Expression expr){
        parent = expr;
    }

    public int getNumArgs(){
        return numArgs;
    }

    public abstract Variable evaluate();


}
