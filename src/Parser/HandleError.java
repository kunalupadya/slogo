package Parser;

public class HandleError extends Exception{

    private final static String undefinedCommandErrorMessage = "This is an undefined syntax";
    private final static String noInputErrorMessage = "No input";
    private final static String syntaxErrorMessage = "No such syntax";
    private final static String interpretationErrorMessage = "Cannot be interpreted";
    private final static String space = " ";
    private Console console;

    public HandleError(){
    }

    public void undefinedCommandErrors(String error){
        console.show(error + space + undefinedCommandErrorMessage);
    }

    public void noInputError(){
        console.show(noInputErrorMessage);
    }

    public void syntaxError(String error){
        console.show(error + syntaxErrorMessage);
    }

    public void interpretationError(String error){
        console.show(error + interpretationErrorMessage);
    }

}
 Pattern.