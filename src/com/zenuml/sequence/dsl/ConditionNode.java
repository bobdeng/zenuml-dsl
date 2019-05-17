package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ConditionNode extends BaseNode implements DslNode {
    private String condition;
    private List<DslNode> ifCondition;
    private List<DslNode> elseCondition;
    private int level;

    public ConditionNode(String condition) {
        this.condition = condition;
        ifCondition = new ArrayList<>();
        elseCondition = new ArrayList<>();
    }

    @Override
    public void toDsl(StringBuffer output) {

        output.append("  if(condition){\n" +
                "    Class1.function();\n" +
                "  } else {\n" +
                "    Class2.function();\n" +
                "  }\n");
    }

    @Override
    public void addChild(DslNode rootClass) {

    }

    public void addElse(DslNode node) {
        node.setLevel(getNextLevel());
        elseCondition.add(node);
    }
}
