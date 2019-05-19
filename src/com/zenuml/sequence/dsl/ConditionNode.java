package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ConditionNode extends BaseNode implements DslNode {
    private String condition;
    private List<DslNode> elseCondition;

    public ConditionNode(String condition,DslNode parent) {
        super();
        this.condition = condition;
        elseCondition = new ArrayList<>();
        this.parent=parent;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append("if(");
        output.append(condition);
        output.append("){\n");
        output.append(
                "    Class1.function();\n" +
                "  } else {\n" +
                "    Class2.function();\n" +
                "  }\n");
    }

    @Override
    public DslNode addChild(DslNode node) {
        node.setLevel(getNextLevel());
        System.out.println(getNextLevel());
        children.add(node);
        return node;
    }

    public void addElse(DslNode node) {
        node.setLevel(getNextLevel());
        elseCondition.add(node);
    }
}
