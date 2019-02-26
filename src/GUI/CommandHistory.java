package Parser;

import java.util.List;

/**
 * @author: Louis Lee
 */

public class CommandHistory {

    private List<String> history;

    public CommandHistory(){
    }

    public void addToHistory(String input) {
        history.add(input);
    }

    public String getPreviousCommand(){
        return history.get(history.size()-1);
    }
}
