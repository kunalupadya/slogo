package Backend.Parser;

public class HandleError extends Exception{

    private static final String undefinedCommandErrorMessage = "This is an undefined syntax";
    private static final String noInputErrorMessage = "No input";
    private static final String syntaxErrorMessage = "No such syntax";
    private static final String interpretationErrorMessage = "Cannot be interpreted";
    private static final String space = " ";
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