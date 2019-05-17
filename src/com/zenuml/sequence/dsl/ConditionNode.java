package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ConditionNode implements DslNode {
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

    }

    @Override
    public void addChild(DslNode rootClass) {

    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public void addElse(DslNode node) {
        elseCondition.add(node);
    }
}
