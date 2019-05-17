package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ConditionNode extends BaseNode implements DslNode {
    private String condition;
    private List<DslNode> ifCondition;
    private List<DslNode> elseCondition;
    private int level;

    public ConditionNode(String condition,DslNode parent) {
        this.condition = condition;
        ifCondition = new ArrayList<>();
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
    public void addChild(DslNode node) {
        node.setLevel(getNextLevel());
        System.out.println(level);
        System.out.println(getNextLevel());
        ifCondition.add(node);
    }

    public void addElse(DslNode node) {
        node.setLevel(getNextLevel());
        elseCondition.add(node);
    }
}
