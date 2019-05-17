package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ConditionNode implements DslNode {
    private String condition;
    private List<DslNode> ifCondition;
    private ConditionNode elseCondition;
    public ConditionNode(String condition) {
        this.condition = condition;
        ifCondition = new ArrayList<>();
    }

    @Override
    public void toDsl(StringBuffer output) {

    }

    @Override
    public void addChild(FunctionNode rootClass) {

    }
}
