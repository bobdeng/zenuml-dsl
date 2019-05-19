package com.zenuml.sequence.dsl;

public class LoopNode extends BaseNode {
    private String conditon;

    public LoopNode(String condition) {
        super();
        this.conditon = condition;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append("while(");
        output.append(conditon);
        output.append("){\n");
        printChindren(output);
        printIndent(output);
        output.append("}\n");
    }
    
}
