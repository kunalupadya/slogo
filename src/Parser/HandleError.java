package Parser;

public class HandleError{

    private final static String undefinedCommandErrorMessage = "This is an undefined syntax";
    private final static String noInputErrorMessage = "No input";
    private final static String syntaxErrorMessage = "Syntax Error";
    private final static String space = " ";

    public HandleError(){

    }

    public void undefinedCommandErrors(String error){
        console.show(error + space + undefinedCommandErrorMessage);
    }

    public void noInputError(){
        console.show(noInputErrorMessage);
    }

    public void syntaxError(String error){
        console.show(syntaxErrorMessage)
    }

}
