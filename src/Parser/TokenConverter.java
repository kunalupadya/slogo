package Parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * @author Louis Lee
 * divides the input string into tokens which will be used in the parsingtree
 */

class TokenConverter {

    private final static String CONSTANT_REGEX = "Constant";
    private final static String VARIABLE_REGEX = "Variable";
    private final static String COMMAND_REGEX = "Command";
    private final static String LIST_START_REGEX = "ListStart";
    private final static String LIST_END_REGEX = "ListEnd";
    private final static String GROUP_START_REGEX = "GroupStart";
    private final static String GROUP_END_REGEX = "GroupEnd";
    private final static String COMMENT_REGEX = "Comment";
    private final static String WHITE_SPACE_REGEX = "Whitespace";
    private final static String NEWLINE_REGEX = "Newline";
    private Map<String, Pattern> myRegexMap;

    TokenConverter(){
        myRegexMap = makeMap();
    }

    private Map<String, Pattern> makeMap() {
        Map<String, Pattern> regexMap = new HashMap<>();
        ResourceBundle resources = ResourceBundle.getBundle("/languageProperties/Syntax");
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            regexMap.put(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE));
        }
        return regexMap;

    }

    private String checkRegex(String input) {
        for(Map.Entry<String, Pattern> entry : myRegexMap.entrySet()){
            Pattern value = entry.getValue();
            if(value.matcher(input).matches()){
                return entry.getKey();
            }
        }
        return "";
    }

    /**
     * checks the regex of the input and returns the right token
     * @param input: word
     * @return relevant token type
     */
    Token checkTypeOfInput(String input) {
        switch (checkRegex(input)) {
            case COMMENT_REGEX:
                return Token.Comment;
            case CONSTANT_REGEX:
                return Token.Constant;
            case VARIABLE_REGEX:
                return Token.Variable;
            case COMMAND_REGEX:
                return Token.Command;
            case LIST_START_REGEX:
                return Token.ListStart;
            case LIST_END_REGEX:
                return Token.ListEnd;
            case GROUP_START_REGEX:
                return Token.GroupStart;
            case GROUP_END_REGEX:
                return Token.GroupEnd;
            case WHITE_SPACE_REGEX:
                return Token.WhiteSpace;
            case NEWLINE_REGEX:
                return Token.NewLine;
            default:
                return Token.Error;
        }
    }

}
