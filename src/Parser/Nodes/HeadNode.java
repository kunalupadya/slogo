package Parser.Nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Louis Lee
 */

public class HeadNode extends Node{

    /*
    Starting node for the ParsingTree
     */

    private List<Node> children = null;
    private String value;

    public HeadNode(String value){
        children = new ArrayList<>();
        this.value = value;
    }


}
