package com.zenuml.sequence.dsl;

public class Loopnode extends BaseNode implements DslNode {
    private String conditon;

    public Loopnode(String condition) {
        super();
        this.conditon = condition;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append("while(");
        output.append(conditon);
        output.append("){");
        printChindren(output);
        printIndent(output);
        output.append("}");
    }
    
}
