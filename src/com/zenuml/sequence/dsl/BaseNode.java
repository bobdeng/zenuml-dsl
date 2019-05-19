package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseNode implements DslNode {
    protected DslNode parent;
    List<DslNode> children;
    private int level;

    public BaseNode() {
        children=new ArrayList<>();
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    protected boolean isRoot() {
        return level == 0;
    }

    protected void printIndent(StringBuffer output) {
        for (int i = 0; i < level; i++) {
            output.append("  ");
        }
    }

    @Override
    public DslNode addChild(DslNode node) {
        node.setLevel(getNextLevel());
        children.add(node);
        return node;
    }


    protected void printChindren(StringBuffer output) {
        children.forEach(dslNode -> dslNode.toDsl(output));
    }

    protected int getNextLevel() {
        return level + 1;
    }
}
