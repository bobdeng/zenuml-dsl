package com.zenuml.sequence.dsl;


import java.util.ArrayList;
import java.util.List;

public class ConditionNode extends BaseNode {
    private String condition;
    private List<ElseNode> elseNodes;

    public ConditionNode(String condition) {
        super();
        this.condition = condition;
        elseNodes=new ArrayList<>();
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append("if(");
        output.append(condition);
        output.append("){\n");
        printChindren(output);
        printIndent(output);
        output.append("}\n");
        elseNodes.forEach(elseNode -> elseNode.toDsl(output));
    }


    public void setElse(ElseNode elseNode) {
        elseNode.parent=this.parent;
        this.elseNodes.add(elseNode);
    }
}
