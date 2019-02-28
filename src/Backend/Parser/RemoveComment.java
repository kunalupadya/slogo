package Backend.Parser;

import java.io.IOException;
import java.io.StringReader;

class RemoveComment {

    private final static String commentPattern1 = "\"";
    private final static String commentPattern2 = "(/\\*((.|\n)*?)\\*/)|//.*";
    private final static String commentPattern3 = "\"";
    private final static String emptyString = "";
    private String output;

    public RemoveComment(String myString){
        output = deleteComment(myString);
    }

    /*
        This part comes from Stack Overflow
     */
    private String deleteComment(String myString){
        StringBuilder newCode = new StringBuilder();
        try (StringReader sr = new StringReader(myString)) {
            boolean inBlockComment = false;
            boolean inLineComment = false;
            boolean out = true;

            int prev = sr.read();
            int cur;
            for(cur = sr.read(); cur != -1; cur = sr.read()) {
                if(inBlockComment) {
                    if (prev == '*' && cur == '/') {
                        inBlockComment = false;
                        out = false;
                    }
                } else if (inLineComment) {
                    if (cur == '\r') { // start untested block
                        sr.mark(1);
                        int next = sr.read();
                        if (next != '\n') {
                            sr.reset();
                        }
                        inLineComment = false;
                        out = false; // end untested block
                    } else if (cur == '\n') {
                        inLineComment = false;
                        out = false;
                    }
                } else {
                    if (prev == '/' && cur == '*') {
                        sr.mark(1); // start untested block
                        int next = sr.read();
                        if (next != '*') {
                            inBlockComment = true; // tested line (without rest of block)
                        }
                        sr.reset(); // end untested block
                    } else if (prev == '/' && cur == '/') {
                        inLineComment = true;
                    } else if (out){
                        newCode.append((char)prev);
                    } else {
                        out = true;
                    }
                }
                prev = cur;
            }
            if (prev != -1 && out && !inLineComment) {
                newCode.append((char)prev);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newCode.toString();
    }

    public String getOutput(){
        return output;
    }
}
