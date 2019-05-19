package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseNode{
    protected BaseNode parent;
    List<BaseNode> children;
    private int level;

    public BaseNode() {
        children=new ArrayList<>();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    protected boolean isRoot() {
        return level == 0;
    }

    protected void printIndent(StringBuffer output) {
        for (int i = 0; i < getLevel(); i++) {
            output.append("  ");
        }
    }

    public final BaseNode addChild(BaseNode node) {
        node.setLevel(getNextLevel());
        children.add(node);
        node.parent=this;
        return node;
    }

    abstract void toDsl(StringBuffer output);


    protected void printChindren(StringBuffer output) {
        children.forEach(dslNode -> dslNode.toDsl(output));
    }

    protected int getNextLevel() {
        return level + 1;
    }

    protected int getLevel() {
        int level=0;
        BaseNode node=this;
        while(node.parent!=null){
            level++;
            node=node.parent;
        }
        return level;
    }
}
