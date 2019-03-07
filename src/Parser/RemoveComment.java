package Parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveComment {


    public RemoveComment(){}

    public String deleteComment(String myString) {
        if (!myString.contains("#")) {
             return myString;
        } else {
            return myString.substring(0, myString.indexOf("#"));
        }
    }

}
