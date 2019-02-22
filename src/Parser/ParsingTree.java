package Parser;
import Parser.Tree.Node;

/**
 * @author: Louis Lee
 */

public class ParsingTree {

    private String language = "English";
    private CommandHistory commandHistory;
    private LanguageSetting languageSetting;


    public ParsingTree(){
        commandHistory = new CommandHistory();
    }

    public void setLanguage(String inputLanguage) {
        language = inputLanguage;
        languageSetting.changeLanguage(language);
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviousCommands(int k) {
        return commandHistory.getPreviousCommand();
    }

    public Node parse(String input) {
        commandHistory.addToHistory(input);

        return root;
    }


}
