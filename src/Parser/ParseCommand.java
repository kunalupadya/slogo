package Parser;

/**
 * @author Louis Lee
 */


public class ParseCommand {

    private String refinedInput;
    private ParsingTree parsingTree;


    public ParseCommand(String consoleInput){
        RemoveComment removeComment = new RemoveComment(consoleInput);
        refinedInput = removeComment.getOutput();
        parsingTree = new ParsingTree();

    }
}
