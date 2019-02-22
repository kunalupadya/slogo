package Parser;

import java.util.List;

public class CommandHistory {

    private List<String> history;

    public CommandHistory(){
    }

    private void addToHistory(String input) {
        history.add(input);
    }
}
