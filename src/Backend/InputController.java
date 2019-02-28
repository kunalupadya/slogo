package Backend;

import Backend.Parser.Token;
import Backend.SLogoExpressions.Expression;

import java.util.List;

public class InputController {

    private int index;
    private String[] userInput;
    private List<Token> tokenList;
    private Expression curr;
    private Expression prev;

    public InputController(String[] input, List<Token> tokenList){
        this(input, tokenList, 0);
    }

    public InputController(String[] input, List<Token> tokenList, int index){
        userInput = input;
        this.tokenList = tokenList;
        this.index = index;
    }

    public void incrementIndex(){
        index++;
    }

    public Token getCurToken(){
        return tokenList.get(index);
    }

    public String getCurInput(){
        return userInput[index];
    }

    public Expression getCurExpression() {
        return curr;
    }

    public void setCurExpression(Expression expr){
        curr = expr;
    }

    public Expression getPrevExpression(){
        return prev;
    }

    public int getInputLength(){
        return userInput.length;
    }

    public int getIndex(){
        return index;
    }

    public boolean hasReachedEnd(){
        return !(index < getInputLength());
    }
}
