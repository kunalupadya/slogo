package Backend.Parser;


/**
 * @author kunalupadya
 */
public class SyntaxError extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public SyntaxError(String message, Object ... values){
        super(String.format(message, values));
    }

    public SyntaxError (Throwable cause, String message, Object ... values) {
        super(String.format(message, values), cause);
    }

    public SyntaxError (Throwable cause) {
        super(cause);
    }
}