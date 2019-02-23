package Parser.Nodes;

import Parser.Token;
import Parser.TokenConverter;

import java.util.List;

public class ListNode {
    private String output;
    private List<Node> Nodes = null;

    public ListNode(String input){
        output = "";
        String[] words;
        input = input.replaceAll("[\\[\\]]", "");
        words = input.split(" ");
        for(int a=0; a<words.length ; a++) {
            String word = words[a];
            Token token = new TokenConverter().checkTypeOfInput(word);
            Node newNode = null;
            if (token == Token.GROUP_START) {
                newNode = new GroupNode(input, commands);
            } else if (token == Token.CONSTANT) {
                newNode = new ConstantNode(input);
            } else if (token == Token.VARIABLE) {
                newNode = new VariableNode(word.replaceAll(":", ""));
            } else if (token == Token.COMMAND) {
                child = commands.get(word);
                if (child == null) {
                    child = state.getCommand(word);
                    child.setParser(this);
                }
                ((Command) child).setup(controller, state);
                prevCmdTo = child instanceof MakeUserInstructionCommand;
                for (int i = 0; i < ((Command) child).numParameters(); i++) {
                    input = createTree(new Input(child, input.getIndex(), input.getWords()));
                }
                if (child instanceof MakeUserInstructionCommand) child.evaluate();

            }
        }
    }

}

