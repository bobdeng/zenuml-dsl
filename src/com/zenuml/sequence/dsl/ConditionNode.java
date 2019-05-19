package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ConditionNode extends BaseNode {
    private String condition;
    private List<BaseNode> elseCondition;
    private ElseNode elseNode;

    public ConditionNode(String condition) {
        super();
        this.condition = condition;
        elseCondition = new ArrayList<>();
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
        elseNode.toDsl(output);
    }


    public void addElse(BaseNode node) {
        node.parent=this;
        elseCondition.add(node);
    }

    public void setElse(ElseNode elseNode) {
        elseNode.parent=this.parent;
        this.elseNode = elseNode;
    }
}
