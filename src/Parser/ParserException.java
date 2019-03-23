package Parser;

/**
 * @author Dhanush Madabusi
 */
public class ParserException extends SLogoException{

    public ParserException(String error){
        super("Parsing Error", error);
    }
}
