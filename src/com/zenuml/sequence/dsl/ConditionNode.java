package com.zenuml.sequence.dsl;


public class ConditionNode extends BaseNode {
    private String condition;
    private ElseNode elseNode;

    public ConditionNode(String condition) {
        super();
        this.condition = condition;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append("if(");
        output.append(condition);
        output.append("){\n");
        printChindren(output);
        printIndent(output);
        output.append("}\n");
        elseNode.toDsl(output);
    }


    public void setElse(ElseNode elseNode) {
        elseNode.parent=this.parent;
        this.elseNode = elseNode;
    }
}
