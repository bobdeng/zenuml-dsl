package com.zenuml.sequence.dsl;

import java.util.List;

public class ConditionNode implements DslNode {
    private String condition;
    private List<DslNode> ifCondition;

    public ConditionNode(String condition) {
        this.condition = condition;
    }

    @Override
    public void toDsl(StringBuffer output) {

    }

    @Override
    public void addChild(FunctionNode rootClass) {

    }
}
