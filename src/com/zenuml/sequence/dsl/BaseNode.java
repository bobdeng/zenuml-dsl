package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseNode{
    protected BaseNode parent;
    List<BaseNode> children;

    public BaseNode() {
        children=new ArrayList<>();
    }


    protected boolean isRoot() {
        return parent == null;
    }

    protected void printIndent(StringBuffer output) {
        for (int i = 0; i < getLevel(); i++) {
            output.append("  ");
        }
    }

    public final BaseNode addChild(BaseNode node) {
        children.add(node);
        node.parent=this;
        return node;
    }

    abstract void toDsl(StringBuffer output);


    protected void printChindren(StringBuffer output) {
        children.forEach(dslNode -> dslNode.toDsl(output));
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
