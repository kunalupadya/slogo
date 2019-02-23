package Parser.Nodes;

import Parser.TokenConverter;

public class GroupNode extends Node {


    private String output;

    public GroupNode(String input){
        output = "";
        input = input.replaceAll("[\\(\\)]", "");
        String word = input.getWords().get(input.getIndex());
            TokenConverter token = new Tokenize().typeOf(word);
            input.addToIndex(1);
            if (token == ChangtoTokenLIST_START) {
                openBrackets++;
            }
            else if (token == Token.LIST_END) {
                openBrackets--;
                if (openBrackets == -1) {
                    break;
                }
            }
            newExpression += word + " ";
        }
        try {
            getChildren().addAll(parser.parseInternal(newExpression.trim()).getChildren());
        } catch (Exception e) {
        }
    }
}
