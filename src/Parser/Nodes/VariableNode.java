package Parser.Nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Louis Lee
 */

public class VariableNode extends Node {


    private List<Node> children = null;
    private String value;

    public VariableNode(String value){
        children = new ArrayList<>();
        this.value = value;
    }

    public Integer isValid(){

    }
}
