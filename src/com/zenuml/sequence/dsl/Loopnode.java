package com.zenuml.sequence.dsl;

public class Loopnode implements DslNode {
    private String conditon;

    public Loopnode(String condition) {
        this.conditon = condition;
    }

    @Override
    public void toDsl(StringBuffer output) {

    }

    @Override
    public void addChild(DslNode rootClass) {

    }

    @Override
    public void setLevel(int level) {

    }
}
