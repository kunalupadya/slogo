package Parser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private final static String commentPattern1 ="\"";
    private final static String commentPattern2 ="(/\\*((.|\n)*?)\\*/)|//.*";
    private final static String commentPattern3 ="\"";
    private final static String emptyString = "";
    private String refinedInput;
    private ParsingTree parsingTree;

    public ParseCommand(String consoleInput){
        refinedInput = removeComment(consoleInput);
        parsingTree = new ParsingTree();
    }

    private String removeComment(String myString){
        String newString = "";

        if (myString.contains(commentPattern3)) {
            if (myString.indexOf(commentPattern3) != 0) {

                String[] stringParts = myString.split(commentPattern1);

                for (int i = 0; i < stringParts.length; i++) {

                    if ((i & 1) == 0) {
                        Pattern commentaryPattern = Pattern.compile(commentPattern2);

                        Matcher m = commentaryPattern.matcher(stringParts[i]);

                        newString += m.replaceAll(emptyString);
                    } else {
                        newString += commentPattern3 + stringParts[i] + commentPattern3;
                    }
                }
            }
        } else {
            Pattern commentaryPattern = Pattern.compile(commentPattern2);

            Matcher m = commentaryPattern.matcher(myString);

            newString += m.replaceAll(emptyString);
        }

        return newString;
    }
}
