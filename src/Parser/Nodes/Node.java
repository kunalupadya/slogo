package Parser.Nodes;

import Parser.ParsingTree;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Louis Lee
 */

public abstract class Node {

    private List<Node> children;
    private String value;

    //default constructor
    public Node(){

    }

    public Node(String value) {
        children = new ArrayList<Node>();
        this.value = value;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }
}
