package Parser.Nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Louis Lee
 */

public class ConstantNode extends Node {


    private List<Node> children = null;
    private Integer value;

    public ConstantNode(String value){
        children = new ArrayList<>();
        this.value = Integer.parseInt(value);
    }

}
