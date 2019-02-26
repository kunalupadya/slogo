package Parser;
import Parser.Nodes.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Louis Lee
 */

public class ParsingTree {

    private String language = "English";
    private String emptyspace = " ";
    private CommandHistory commandHistory;
    private LanguageSetting languageSetting;


    public ParsingTree(String input){
        commandHistory.addToHistory(input);
        Node root = makeTree(input);
    }

    public void setLanguage(String inputLanguage) {
        language = inputLanguage;
        languageSetting.changeLanguage(language);
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviousCommands(){
        return commandHistory.getPreviousCommand();
    }


    public Node makeTree(String input){
        ArrayList<String> words;
        words = new ArrayList<>(Arrays.asList(input.split(emptyspace)));
        Node headNode = new HeadNode(input);
        Node pointer = headNode;
        for(int a=0; a<words.size() ; a++) {
            String word = words.get(a);
            Token token = new TokenConverter().checkTypeOfInput(word);
            Node newNode = null;
            if (token == Token.CONSTANT) {
                newNode = new ConstantNode(word);
            } else if (token == Token.VARIABLE) {
                newNode = new VariableNode(word.replaceAll(":", ""));
            } else if (token == Token.COMMAND) {
                newNode = new CommandNode(word);
            }
            pointer.addChild(newNode);
            pointer = newNode;
        }

    }

}
