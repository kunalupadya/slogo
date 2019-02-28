package Backend.Parser;

import Backend.InputController;
import Backend.InternalController;
import Backend.SLogoExpressions.Expression;
import Backend.SLogoExpressions.ListExpr;
import Backend.Commands.Command;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis Lee
 * @co-author Dhanush Madabusi
 */

public class ParseCommand {

    private final String whiteSpace = "\\s+";
    private final String noInput = "";
    private LanguageSetting langSetting;
    private ArrayList<Command> commandsList;
    private HandleError handleError = new HandleError();
    private List<Token> tokenList;
    private InternalController controller;


    public ParseCommand (InternalController controller){
        this.controller = controller;
        langSetting = new LanguageSetting(controller.getCodeLanguage());
    }

    private String[] cleanInput(String consoleInput) {
        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput)){
            handleError.noInputError();
        }
        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        String [] listOfWords = refinedInput.split(whiteSpace);

        //translate the input into default language
        //TODO: try catch block if command is not valid
        return langSetting.translateCommand(listOfWords);

    }

    private List<Token> addToTokenList(String[] translatedListOfWords){
        TokenConverter tokenConverter = new TokenConverter();
        List<Token> list = new ArrayList<>();
        for(String str: translatedListOfWords){
            list.add(tokenConverter.checkTypeOfInput(str));
        }
        return list;
    }

    public Expression parseInput(String consoleInput){
        String [] inputWords = cleanInput(consoleInput);
        //convert word into tokens and check validity
        tokenList = addToTokenList(inputWords);
        var inputController = new InputController(inputWords, tokenList);
        Expression root = new ListExpr(controller);
        while(!inputController.hasReachedEnd()){
            inputController = parseRecursive(inputController);
            Expression cur = inputController.getCurExpression();
            if (cur != null){
                root.addChild(cur);
                cur.setParent(root);
                inputController.incrementIndex();
            }
        }
        return root;
    }

    //TODO: handle exceptions
    private InputController parseRecursive(InputController inputController) {
        Expression expr = constructExpression(inputController);
        int count = 0;
        while (count < expr.getNumArgs() && !inputController.hasReachedEnd()){
            inputController.incrementIndex();
            InputController subExpr = parseRecursive(inputController);
            subExpr.getCurExpression().setParent(expr);
            expr.addChild(subExpr.getCurExpression());
            count++;
        }
        inputController.setCurExpression(expr);
        return inputController;
    }

    private Expression constructExpression(InputController inputController) throws Exception{
        Token curToken = inputController.getCurToken();
        Expression expr;
        if (curToken == Token.COMMAND){
            expr = createCommand(inputController);
        }
        else{
            expr = (Expression) createObject(inputController.getCurInput(), "backend.SLogoExpressions" + curToken.toString() + "Expr");
        }
        return expr;
    }

    private Expression createCommand(InputController inputController) throws Exception{
        Command com = (Command) createObject(inputController.getCurInput(), "Backend.Commands." + inputController.getCurInput() + "Command");
        //TODO: exception handling and check for user defined commands
        return com;
    }

    private Object createObject(String name, String classPath) throws Exception{
        Class<?> cl = Class.forName(classPath);
        Constructor<?> constr = cl.getDeclaredConstructor(name.getClass(), controller.getClass());
        return constr.newInstance(name, controller);
    }


}
