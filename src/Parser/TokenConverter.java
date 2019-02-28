package Parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

class TokenConverter {

    private final static String CONSTANT_REGEX = "Constant";
    private final static String VARIABLE_REGEX = "Variable";
    private final static String COMMAND_REGEX = "Command";
    private final static String LIST_START_REGEX = "ListStart";
    private final static String LIST_END_REGEX = "ListEnd";
    private final static String GROUP_START_REGEX = "GroupStart";
    private final static String GROUP_END_REGEX = "GroupEnd";
    private final static String WHITE_SPACE_REGEX = "Whitespace";
    private final static String NEWLINE_REGEX = "Newline";
    private Map<String, Pattern> myRegexMap;

    TokenConverter(){
        myRegexMap = makeMap();
    }

    private HashMap<String, Pattern> makeMap() {
        HashMap<String, Pattern> regexMap = new HashMap<>();
        ResourceBundle resources = ResourceBundle.getBundle("resources.languages/Syntax.properties");
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

    Token checkTypeOfInput(String input) {
        switch (checkRegex(input)) {
            case CONSTANT_REGEX:
                return Token.CONSTANT;
            case VARIABLE_REGEX:
                return Token.VARIABLE;
            case COMMAND_REGEX:
                return Token.COMMAND;
            case LIST_START_REGEX:
                return Token.LIST_START;
            case LIST_END_REGEX:
                return Token.LIST_END;
            case GROUP_START_REGEX:
                return Token.GROUP_START;
            case GROUP_END_REGEX:
                return Token.GROUP_END;
            case WHITE_SPACE_REGEX:
                return Token.WHITESPACE;
            case NEWLINE_REGEX:
                return Token.NEWLINE;
            default:
                return Token.ERROR;
        }
    }

}
