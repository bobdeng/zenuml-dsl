package com.zenuml.sequence.dsl;

public class ConditionNode implements DslNode {
    private String condition;
    private DslNode ifCondition;

    public ConditionNode(String condition, DslNode ifCondition) {
        this.condition = condition;
        this.ifCondition = ifCondition;
    }

    @Override
    public void toDsl(StringBuffer output) {

    }

    @Override
    public void addChild(FunctionNode rootClass) {

    }
}
