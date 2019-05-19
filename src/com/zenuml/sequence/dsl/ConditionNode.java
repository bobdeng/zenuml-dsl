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
        if (elseCondition.size() > 0) {
            printIndent(output);
            output.append("else {\n");
            elseCondition.forEach(dslNode -> dslNode.toDsl(output));
            printIndent(output);
            output.append("}\n");
        }
    }


    public void addElse(BaseNode node) {
        elseCondition.add(node);
    }

    public void setElse(ElseNode elseNode) {
        this.elseNode = elseNode;
    }
}
