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
        if(elseCondition.size()>0){
            printIndent(output);
            output.append("} else {\n");
            elseCondition.forEach(dslNode -> dslNode.toDsl(output));
            printIndent(output);
            output.append("}\n");
        }
    }

    @Override
    public BaseNode addChild(BaseNode node) {
        node.setLevel(getNextLevel());
        children.add(node);
        return node;
    }

    public void addElse(BaseNode node) {
        node.setLevel(getNextLevel());
        elseCondition.add(node);
    }

    public void setElse(ElseNode elseNode){
        this.elseNode=elseNode;
    }
}
