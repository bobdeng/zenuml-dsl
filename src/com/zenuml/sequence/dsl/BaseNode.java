package com.zenuml.sequence.dsl;

public abstract class BaseNode implements DslNode {
    private DslNode parent;

    private int level;


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


    protected int getNextLevel() {
        return level + 1;
    }
}
